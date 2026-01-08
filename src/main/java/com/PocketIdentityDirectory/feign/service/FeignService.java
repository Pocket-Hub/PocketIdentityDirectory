package com.PocketIdentityDirectory.feign.service;

import com.PocketIdentityDirectory.feign.dtos.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.responses.IASUserResponse;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import com.PocketIdentityDirectory.feign.mappers.FeignDTOMapper;
import com.PocketIdentityDirectory.users.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeignService {

    private final IASFeignClient client;

    @Autowired
    public FeignService(IASFeignClient client) {
        this.client = client;
    }

    public List<User> getIASUsers(){
        List<IASUserResponse> feignUsers = client.getUsers().getResources();
        System.out.println(feignUsers);
        List<User> users = new ArrayList<>();
        for (IASUserResponse feignUser : feignUsers) {

            users.add(FeignDTOMapper.mapFeignIASUserResponseToIASUser(feignUser));
        }
        return users;
    }

    public User createIASUser(CreateIASUserRequest dto){
        IASUserResponse user = client.createUser(dto);

        return FeignDTOMapper.mapFeignIASUserResponseToIASUser(user);
    }



}
