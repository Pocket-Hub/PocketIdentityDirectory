package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.*;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.service.IASUsersFeignService;
import com.PocketIdentityDirectory.mappers.IASUsersDTOMapper;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final IASUsersFeignService iasUserService;
    private final IASUsersDTOMapper mapper;

    @Autowired
    public UserService(UserRepository repository, IASUsersFeignService iasUserService, IASUsersDTOMapper mapper) {
        this.repository = repository;
        this.iasUserService = iasUserService;
        this.mapper = mapper;
    }

    public List<User> syncUsers() {
        List<IASUser> iasUsers = iasUserService.getIASUsers();
        List<User> users = new ArrayList<>();

        for (IASUser iasUser : iasUsers) {
            users.add(mapper.mapIASUserToUser(iasUser));
        }

        return repository.saveAll(users);
    }

    public List<User> getUsersWithOptionalFilters(String lastName, Status status, UserType type, String groupName) {

        return repository.filterUsersByUserStatusOrUserTypeOrLastNameOrGroupName(type, lastName, status, groupName);
    }

    public User getUserById(UUID id) {
        Optional<User> optUser = repository.findById(id);

        return optUser.orElseThrow();
    }

    public User createUser(User user) {
        user.setStatus(Status.ACTIVE);
        IASUser iasUser = IASUsersDTOMapper.mapUserToIASUser(user);

        return mapper.mapIASUserToUser(iasUserService.createIASUser(iasUser));
    }

    public void deleteUser(UUID id) {
        iasUserService.deleteUser(id);
        repository.deleteById(id);
    }

    public User updateUser(User user, UUID id) {
        IASUser iasUser = IASUsersDTOMapper.mapUserToIASUser(user);

        return mapper.mapIASUserToUser(iasUserService.updateUser(iasUser, id));
    }

    public void assignGroups(UUID id, List<UUID> groupIDs){
        PatchOp patch = new PatchOp();
        Bulk bulk = new Bulk();
        List<BulkOp> bulkOperations = new ArrayList<>();
        patch.setOperations(List.of(new Operations("add", "members", List.of(new PatchValue(id.toString())))));

        for (UUID groupID : groupIDs) {
            BulkOp bulkOp = new BulkOp("PATCH", UUID.randomUUID(), "/Groups/" + groupID, patch);
            bulkOperations.add(bulkOp);
        }

        bulk.setOperations(bulkOperations);

        iasUserService.assignGroup(bulk);

    }

}
