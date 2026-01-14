package com.PocketIdentityDirectory.groups.services;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.*;
import com.PocketIdentityDirectory.feign.service.IASGroupFeignService;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.repositories.GroupRepository;
import com.PocketIdentityDirectory.mappers.IASGroupDTOMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GroupService {

    private final GroupRepository repository;
    private final IASGroupFeignService feignService;

    public GroupService(GroupRepository repository, IASGroupFeignService feignService) {
        this.repository = repository;
        this.feignService = feignService;
    }

    public List<Group> filterGroups(String name, String displayName){
        return repository.filterGroupsByNameAndDisplayName(name, displayName);
    }


    public List<Group> syncGroups() {
        List<IASGroup> iasGroups = feignService.getAllGroups();
        List<Group> groups = new ArrayList<>();

        for (IASGroup iasGroup : iasGroups) {
            groups.add(IASGroupDTOMapper.mapIASGroupToGroup(iasGroup));
        }

        return repository.saveAll(groups);
    }

    public Group createGroup(Group group) {
        IASGroup iasGroup = IASGroupDTOMapper.mapGroupToIASGroup(group);

        return IASGroupDTOMapper.mapIASGroupToGroup(feignService.createGroup(iasGroup));
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

        return IASGroupDTOMapper.mapIASGroupToGroup(feignService.updateGroup(iasGroup, id));
    }

    public List<Group> getGroupsByIds(List<UUID> ids){
        return repository.findAllById(ids);
    }

    public void addMembers(UUID groupId, List<UUID> memberIds, String action){
        PatchOp patch = new PatchOp();
        List<Operations> ops = new ArrayList<>();
        List<PatchValue> ids = new ArrayList<>();

        for (UUID memberId : memberIds) {
            ids.add(new PatchValue(memberId.toString()));
        }

        ops.add(new Operations(action, "members", "add".equalsIgnoreCase(action)? ids : null));
        patch.setOperations(ops);

        Bulk bulk = new Bulk();
        BulkOp bulkOp = new BulkOp("PATCH", UUID.randomUUID(), "/Groups/" + groupId, patch);
        bulk.setOperations(List.of(bulkOp));

        feignService.addUsers(bulk);
    }

}
