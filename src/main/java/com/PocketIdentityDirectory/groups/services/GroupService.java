package com.PocketIdentityDirectory.groups.services;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.repositories.GroupRepository;
import com.PocketIdentityDirectory.mappers.IASGroupDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService {

    private final GroupRepository repository;
    private final IASFeignClient feignClient;

    @Autowired
    public GroupService(GroupRepository repository, IASFeignClient feignClient) {
        this.repository = repository;
        this.feignClient = feignClient;
    }

    public List<Group> getGroups(){
        List<IASGroup> iasGroups = feignClient.getGroup().getResources();
        List<Group> groups = new ArrayList<>();

        for (IASGroup iasGroup : iasGroups) {
            groups.add(IASGroupDTOMapper.mapIASGroupToGroup(iasGroup));
        }

        return repository.saveAll(groups);
    }

}
