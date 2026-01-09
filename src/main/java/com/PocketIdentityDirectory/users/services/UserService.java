package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.mappers.IASUsersDTOMapper;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests.UpdateIASUserRequest;
import com.PocketIdentityDirectory.feign.service.IASUsersFeignService;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
import com.PocketIdentityDirectory.users.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.users.web.dtos.requests.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<User> filterUsers(String lastName, Status status, UserType type){

        return repository.filterUsersByUserStatusOrUserTypeOrLastName(type, lastName, status);
    }

    public User getUserById(UUID id){
        Optional<User> optUser = repository.findById(id);

        return optUser.orElseThrow();
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
