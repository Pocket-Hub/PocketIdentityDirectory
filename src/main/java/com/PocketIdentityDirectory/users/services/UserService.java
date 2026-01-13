package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.service.IASUsersFeignService;
import com.PocketIdentityDirectory.mappers.IASUsersDTOMapper;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
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

    public List<User> syncUsers() {
        return repository.saveAll(IASUsersFeignService.getIASUsers());
    }

    public List<User> getUsersWithOptionalFilters(String lastName, Status status, UserType type) {

        return repository.filterUsersByUserStatusOrUserTypeOrLastName(type, lastName, status);
    }

    public User getUserById(UUID id) {
        Optional<User> optUser = repository.findById(id);

        return optUser.orElseThrow();
    }

    public User createUser(User user) {

        user.setStatus(Status.ACTIVE);

        return IASUsersFeignService.createIASUser(IASUsersDTOMapper.mapUserToIASUser(user));
    }

    public void deleteUser(UUID id) {
        IASUsersFeignService.deleteUser(id);
        repository.deleteById(id);
    }

    public User updateUser(User user) {
        IASUser iasUser = IASUsersDTOMapper.mapUserToIASUser(user);

        return IASUsersFeignService.updateUser(iasUser);
    }
}
