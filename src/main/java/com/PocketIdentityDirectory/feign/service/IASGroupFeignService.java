package com.PocketIdentityDirectory.feign.service;


import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.Bulk;
import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.PatchOp;
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
        return client.getGroups().getResources();
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

    public void addUsers(Bulk bulk){
        client.bulkOp(bulk);
    }


}
