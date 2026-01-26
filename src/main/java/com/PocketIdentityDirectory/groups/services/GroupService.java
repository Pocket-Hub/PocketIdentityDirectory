package com.PocketIdentityDirectory.groups.services;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.service.IASGroupFeignService;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.repositories.GroupRepository;
import com.PocketIdentityDirectory.mappers.IASGroupDTOMapper;
import com.PocketIdentityDirectory.users.services.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    private final GroupRepository repository;
    private final IASGroupFeignService feignService;
    private final IASGroupDTOMapper mapper;
    private final UserService userService;

    public GroupService(GroupRepository repository, IASGroupFeignService feignService, IASGroupDTOMapper mapper, UserService userService) {
        this.repository = repository;
        this.feignService = feignService;
        this.mapper = mapper;
        this.userService = userService;
    }

    public List<Group> filterGroups(String name, String displayName) {
        return repository.filterGroupsByNameAndDisplayName(name, displayName);
    }

//    @Scheduled(fixedRate = 100_000)
    public void syncGroups() {
        List<IASGroup> iasGroups = feignService.getAllGroups();
        List<Group> groups = new ArrayList<>();

        for (IASGroup iasGroup : iasGroups) {
            groups.add(mapper.mapIASGroupToGroup(iasGroup));
        }

        repository.saveAll(groups);

        List<Group> deletion = repository.findAllByLastUpdate(Instant.now().minus(Duration.ofMinutes(3)));

        repository.deleteAll(deletion);
    }

    public Group createGroup(Group group) {
        IASGroup iasGroup = IASGroupDTOMapper.mapGroupToIASGroup(group);
        return repository.save(mapper.mapIASGroupToGroup(feignService.createGroup(iasGroup)));
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

        return repository.save(mapper.mapIASGroupToGroup(feignService.updateGroup(iasGroup, id)));
    }

    public List<Group> getGroupsByIds(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    public Group addMembers(UUID groupId, List<UUID> memberIds, String action) {

        long start = System.currentTimeMillis();
        System.out.println("GroupService: " + LocalDateTime.now());
        userService.assignUsersToGroup(action, groupId, memberIds);

        Group group = repository.findById(groupId).orElseThrow();

        System.out.println("FINISH: " + LocalDateTime.now());
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        return group;
    }

    public Group getGroupById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

}
