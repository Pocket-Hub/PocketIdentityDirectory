package com.PocketIdentityDirectory.groups.services;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.*;
import com.PocketIdentityDirectory.feign.service.IASGroupFeignService;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.repositories.GroupRepository;
import com.PocketIdentityDirectory.mappers.IASGroupDTOMapper;
import jdk.dynalink.Operation;
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

    public List<Group> getGroups() {
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
        IASGroup iasGroup = IASGroupDTOMapper.mapGroupToIASGroup(group);

        return IASGroupDTOMapper.mapIASGroupToGroup(feignService.updateGroup(iasGroup, id));
    }

    public List<Group> getGroupsByIds(List<UUID> ids){
        return repository.findAllById(ids);
    }

    public void addMembers(UUID groupId, List<UUID> memberIds){
        PatchOp patch = new PatchOp();
        List<Operations> ops = new ArrayList<>();
        List<PatchValue> ids = new ArrayList<>();

        for (UUID memberId : memberIds) {
            ids.add(new PatchValue(memberId.toString()));
        }

        ops.add(new Operations("add", "members", ids));
        patch.setOperations(ops);

        Bulk bulk = new Bulk();
        BulkOp bulkOp = new BulkOp("PATCH", UUID.randomUUID(), "/Groups/" + groupId, patch);
        bulk.setOperations(List.of(bulkOp));

        feignService.addUsers(bulk);
    }

}
