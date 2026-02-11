package com.PocketIdentityDirectory.groups.services;

import com.PocketIdentityDirectory.exceptions.EntityNotFoundException;
import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.service.IASGroupFeignService;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.repositories.GroupRepository;
import com.PocketIdentityDirectory.mappers.IASGroupDTOMapper;
import com.PocketIdentityDirectory.users.services.UserService;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupService {

    private final GroupRepository repository;
    private final IASGroupFeignService feignService;
    private final IASGroupDTOMapper mapper;
    private final UserService userService;
    private long version = 0;

    public GroupService(GroupRepository repository, IASGroupFeignService feignService, IASGroupDTOMapper mapper, UserService userService) {
        this.repository = repository;
        this.feignService = feignService;
        this.mapper = mapper;
        this.userService = userService;
    }

    public List<Group> filterGroups(String name, String displayName) {
        return repository.filterGroupsByNameAndDisplayName(name, displayName);
    }

    public long getResourceCount() {
        return repository.count();
    }

    public void syncGroups() {
        version++;
        if (version < 0){
            version = 0;
        }

        List<IASGroup> iasGroups = feignService.getAllGroups();
        List<Group> groups = new ArrayList<>();

        for (IASGroup iasGroup : iasGroups) {
            groups.add(mapper.mapIASGroupToGroup(iasGroup, version));
        }

        repository.saveAll(groups);

        List<Group> deletion = repository.findAllByVersionNotEqualTo(version);

        repository.deleteAll(deletion);
    }

    public Group createGroup(Group group) {
        IASGroup iasGroup = IASGroupDTOMapper.mapGroupToIASGroup(group);
        return repository.save(mapper.mapIASGroupToGroup(feignService.createGroup(iasGroup), version));
    }

    public void deleteGroup(UUID id) {
        feignService.deleteGroup(id);
        repository.deleteById(id);
    }

    public Group updateGroup(Group group, UUID id) {
        Group savedGroup = repository.findById(id).orElseThrow();
        savedGroup.setDescription(group.getDescription());
        savedGroup.setDisplayName(group.getDisplayName());
        IASGroup iasGroup = IASGroupDTOMapper.mapGroupToIASGroup(savedGroup);

        return repository.save(mapper.mapIASGroupToGroup(feignService.updateGroup(iasGroup, id), version));
    }

    public List<Group> getGroupsByIds(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    public Group addMembers(UUID groupId, List<UUID> memberIds, String action) {

        userService.assignUsersToGroup(action, groupId, memberIds);

        Group group = repository.findById(groupId).orElseThrow();

        return group;
    }

    public Group getGroupById(UUID id) {
        Optional<Group> optGroup = repository.findById(id);
        if (optGroup.isEmpty()){
            throw new EntityNotFoundException("Group with this ID does not exist.");
        }
        return optGroup.get();
    }

}
