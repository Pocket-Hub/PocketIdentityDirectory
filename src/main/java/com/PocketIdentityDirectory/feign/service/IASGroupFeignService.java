package com.PocketIdentityDirectory.feign.service;


import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroupResponseList;
import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.Bulk;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUserResponseList;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IASGroupFeignService {

    private final IASFeignClient client;

    @Autowired
    public IASGroupFeignService(IASFeignClient client) {
        this.client = client;
    }

    public List<IASGroup> getAllGroups() {
        int count = 10;
        IASGroupResponseList response = client.getGroups(count, 1);
        List<IASGroup> groups = response.getResources();
        int total = response.getTotalResults();
        int startIndex = response.getStartIndex() + count;

        while (startIndex <= total){
            response = client.getGroups(count, startIndex);
            groups.addAll(response.getResources());
            startIndex += count;
        }

        return groups;
    }

    public IASGroup createGroup(IASGroup group) {
        return client.createGroup(group);
    }

    public void deleteGroup(UUID id) {
        client.deleteGroup(id);
    }

    public IASGroup updateGroup(IASGroup iasGroup, UUID id) {
        return client.updateGroup(iasGroup, id);
    }

    public void addUsers(Bulk bulk) {
        client.bulkOp(bulk);
    }

    public IASGroup getSpecificGroup(UUID id){
        return client.getSpecificGroup(id);
    }


}
