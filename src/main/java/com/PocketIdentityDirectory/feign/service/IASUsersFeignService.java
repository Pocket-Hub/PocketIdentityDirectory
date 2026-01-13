package com.PocketIdentityDirectory.feign.service;

import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import com.PocketIdentityDirectory.mappers.IASUsersDTOMapper;
import com.PocketIdentityDirectory.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class IASUsersFeignService {

    private final IASFeignClient client;

    @Autowired
    public IASUsersFeignService(IASFeignClient client) {
        this.client = client;
    }

    public List<User> getIASUsers() {
        List<IASUser> feignUsers = client.getUsers().getResources();
        System.out.println(feignUsers);
        List<User> users = new ArrayList<>();
        for (IASUser feignUser : feignUsers) {
            users.add(IASUsersDTOMapper.mapIASUserToUser(feignUser));
        }
        return users;
    }

    public User createIASUser(IASUser dto) {
        IASUser user = client.createUser(dto);

        return IASUsersDTOMapper.mapIASUserToUser(user);
    }

    public void deleteUser(UUID id) {
        client.deleteUser(id);
    }

    public User updateUser(IASUser user) {
        IASUser iasUser = client.updateUser(user, user.getId());

        return IASUsersDTOMapper.mapIASUserToUser(iasUser);
    }


}
