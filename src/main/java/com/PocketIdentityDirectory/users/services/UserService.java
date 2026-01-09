package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.IASEmail;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.IASName;
import com.PocketIdentityDirectory.mappers.IASUsersDTOMapper;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests.UpdateIASUserRequest;
import com.PocketIdentityDirectory.feign.service.IASUsersFeignService;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.web.dtos.requests.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final IASUsersFeignService IASUsersFeignService;

    @Autowired
    public UserService(UserRepository repository, IASUsersFeignService IASUsersFeignService) {
        this.repository = repository;
        this.IASUsersFeignService = IASUsersFeignService;
    }

    public List<User> getUsers() {
        return repository.saveAll(IASUsersFeignService.getIASUsers());
    }

    public User createUser(CreateUserRequest dto) {

        return IASUsersFeignService.createIASUser(IASUsersDTOMapper.mapCreateUserRequestToCreateIASUserRequest(dto));
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
        IASUsersFeignService.deleteUser(id);
    }

    public User updateUser(UpdateUserRequest dto) {
        UpdateIASUserRequest feignUser = IASUsersDTOMapper.mapUpdateUserRequestToUpdateIASUserRequest(dto);

        return IASUsersFeignService.updateUser(feignUser);
    }
}
