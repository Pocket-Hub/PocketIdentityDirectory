package com.PocketIdentityDirectory.groups.services;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import com.PocketIdentityDirectory.feign.service.IASGroupFeignService;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.repositories.GroupRepository;
import com.PocketIdentityDirectory.mappers.IASGroupDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Group> getGroups(){
        List<IASGroup> iasGroups = feignService.getAllGroups();
        List<Group> groups = new ArrayList<>();

        for (IASGroup iasGroup : iasGroups) {
            groups.add(IASGroupDTOMapper.mapIASGroupToGroup(iasGroup));
        }

        return repository.saveAll(groups);
    }

    public Group createGroup(Group group){
        IASGroup iasGroup = IASGroupDTOMapper.mapGroupToIASGroup(group);

        return IASGroupDTOMapper.mapIASGroupToGroup(feignService.createGroup(iasGroup));
    }

    public void deleteGroup(UUID id){
        feignService.deleteGroup(id);
        repository.deleteById(id);
    }

    public Group updateGroup(Group group, UUID id){
        IASGroup iasGroup = IASGroupDTOMapper.mapGroupToIASGroup(group);

        return IASGroupDTOMapper.mapIASGroupToGroup(feignService.updateGroup(iasGroup, id));
    }

}
