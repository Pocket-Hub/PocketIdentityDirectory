package com.PocketIdentityDirectory.feign.service;

import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.Bulk;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUserResponseList;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IASUsersFeignService {

    private final IASFeignClient client;

    @Autowired
    public IASUsersFeignService(IASFeignClient client) {
        this.client = client;
    }

    public List<IASUser> getIASUsers() {
        IASUserResponseList response = client.getUsers(10, 1);
        List<IASUser> users = response.getResources();
        int total = response.getTotalResults();
        int startIndex = response.getStartIndex() + 10;

        while (startIndex <= total){
            response = client.getUsers(10, startIndex);
            users.addAll(response.getResources());
            startIndex += 10;
        }

        return users;
    }

    public IASUser createIASUser(IASUser dto) {
        return client.createUser(dto);
    }

    public void deleteUser(UUID id) {
        client.deleteUser(id);
    }

    public IASUser updateUser(IASUser user, UUID id) {
        return client.updateUser(user, id);
    }

    public void assignGroup(Bulk bulk) {
        client.bulkOp(bulk);
    }
}
