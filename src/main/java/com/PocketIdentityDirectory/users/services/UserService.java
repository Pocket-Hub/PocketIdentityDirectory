package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.exceptions.EntityNotFoundException;
import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.*;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.service.IASUsersFeignService;
import com.PocketIdentityDirectory.mappers.IASUsersDTOMapper;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mapping.AccessOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.time.Duration;
import java.time.Instant;
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

//    @Scheduled(fixedRate = 100_000, initialDelay = 10_000)
    public void syncUsers() {
        List<IASUser> iasUsers = iasUserService.getIASUsers();
        List<User> users = new ArrayList<>();

        for (IASUser iasUser : iasUsers) {
            users.add(mapper.mapIASUserToUser(iasUser));
        }

        repository.saveAll(users);

        List<User> deletion = repository.findAllByLastUpdate(Instant.now().minus(Duration.ofMinutes(3)));

        repository.deleteAll(deletion);
    }

    public List<User> getUsersWithOptionalFilters(String lastName, Status status, UserType type, String groupName) {

        return repository.filterUsersByUserStatusOrUserTypeOrLastNameOrGroupName(type, lastName, status, groupName);
    }

    public User getUserById(UUID id) {
        Optional<User> optUser = repository.findById(id);

        if (optUser.isEmpty()) {
            throw new EntityNotFoundException("User with this ID does not exist.");
        }

        return optUser.get();
    }

    public List<User> getUsersWithIDList(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    public User createUser(User user) {
        user.setStatus(Status.ACTIVE);
        IASUser iasUser = IASUsersDTOMapper.mapUserToIASUser(user);

        return repository.save(mapper.mapIASUserToUser(iasUserService.createIASUser(iasUser)));
    }

    public void deleteUser(UUID id) {
        iasUserService.deleteUser(id);
        repository.deleteById(id);
    }

    public User updateUser(User user, UUID id) {
        IASUser iasUser = IASUsersDTOMapper.mapUserToIASUser(user);

        return repository.save(mapper.mapIASUserToUser(iasUserService.updateUser(iasUser, id)));
    }

    public User assignGroups(UUID id, List<UUID> groupIDs, String action) {
        PatchOp patch = new PatchOp();
        Bulk bulk = new Bulk();
        List<BulkOp> bulkOperations = new ArrayList<>();

        patch.setOperations(List.of(new Operations(action,
                "add".equalsIgnoreCase(action) ? "members" : "members[value eq \"" + id + "\"]", "add".equalsIgnoreCase(action) ? List.of(new PatchValue(id.toString())) : null)));

        for (UUID groupID : groupIDs) {
            BulkOp bulkOp = new BulkOp("PATCH", UUID.randomUUID(), "/Groups/" + groupID, patch);
            bulkOperations.add(bulkOp);
        }

        bulk.setOperations(bulkOperations);

        iasUserService.assignGroup(bulk);


        return repository.save(mapper.mapIASUserToUser(iasUserService.getSpecificUser(id)));

    }

    public void assignUsersToGroup(String action, UUID groupId, List<UUID> userIds) {
        Bulk bulk = new Bulk();
        List<BulkOp> bulkOperations = new ArrayList<>();
        List<Operations> ops = new ArrayList<>();
        PatchOp patch = new PatchOp();

        for (UUID memberId : userIds) {
            ops.add(new Operations(action,
                    "add".equalsIgnoreCase(action) ? "members" : "members[value eq \"" + memberId + "\"]", "add".equalsIgnoreCase(action) ? List.of(new PatchValue(memberId.toString())) : null));
        }
        patch.setOperations(ops);
        BulkOp bulkOp = new BulkOp("PATCH", UUID.randomUUID(), "/Groups/" + groupId, patch);
        bulkOperations.add(bulkOp);
        bulk.setOperations(bulkOperations);

        iasUserService.assignGroup(bulk);
        List<IASUser> iasUsers = iasUserService.getSpecificUsers(userIds);
        List<User> users = new ArrayList<>();

        for (IASUser iasUser : iasUsers) {
            users.add(mapper.mapIASUserToUser(iasUser));
        }

        repository.saveAll(users);
    }

}
