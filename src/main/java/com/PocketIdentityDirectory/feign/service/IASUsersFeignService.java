package com.PocketIdentityDirectory.feign.service;

import com.PocketIdentityDirectory.mappers.IASUsersDTOMapper;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests.UpdateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.responses.IASUserResponse;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
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
        List<IASUserResponse> feignUsers = client.getUsers().getResources();
        System.out.println(feignUsers);
        List<User> users = new ArrayList<>();
        for (IASUserResponse feignUser : feignUsers) {

            users.add(IASUsersDTOMapper.mapFeignIASUserResponseToIASUser(feignUser));
        }
        return users;
    }

    public User createIASUser(CreateIASUserRequest dto) {
        IASUserResponse user = client.createUser(dto);

        return IASUsersDTOMapper.mapFeignIASUserResponseToIASUser(user);
    }

    public void deleteUser(UUID id) {
        client.deleteUser(id);
    }

    public User updateUser(UpdateIASUserRequest dto){
        IASUserResponse user = client.updateUser(dto, dto.getId());

        return IASUsersDTOMapper.mapFeignIASUserResponseToIASUser(user);
    }


}
