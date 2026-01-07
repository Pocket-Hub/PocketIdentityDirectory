package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.IASFeignClient;
import com.PocketIdentityDirectory.feign.dtos.IASUserRequest;
import com.PocketIdentityDirectory.users.models.IASUser;
import com.PocketIdentityDirectory.users.repositories.IASUserRepository;
import com.PocketIdentityDirectory.web.mappers.FeignDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IASUserService {

    private final IASUserRepository repository;
    private final IASFeignClient feignClient;

    @Autowired
    public IASUserService(IASUserRepository repository, IASFeignClient feignClient) {
        this.repository = repository;
        this.feignClient = feignClient;
    }

    public List<IASUser> getUsers() {
        List<IASUserRequest> feignUsers = feignClient.getUsers().getResources();
        System.out.println(feignUsers);
        List<IASUser> users = new ArrayList<>();
        for (IASUserRequest feignUser : feignUsers) {

            users.add(FeignDTOMapper.mapFeignIASUserRequestToIASUser(feignUser));
        }
        repository.saveAll(users);
        return repository.findAll();
    }




}
