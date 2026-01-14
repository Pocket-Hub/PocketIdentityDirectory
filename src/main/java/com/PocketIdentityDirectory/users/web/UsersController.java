package com.PocketIdentityDirectory.users.web;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.users.services.UserService;
import com.PocketIdentityDirectory.users.web.dtos.AssignGroupsRequest;
import com.PocketIdentityDirectory.users.web.dtos.GetAllUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<GetAllUsersResponse> getUsers(@RequestParam(required = false) String status, @RequestParam(required = false) String userType, @RequestParam(required = false) String lastName, @RequestParam(required = false) String groupName) {

        Status statusEnum =
                status == null ? null : Status.valueOf(status.toUpperCase());

        UserType userTypeEnum =
                userType == null ? null : UserType.valueOf(userType.toUpperCase());

        List<User> users = new ArrayList<>(userService.getUsersWithOptionalFilters(lastName, statusEnum, userTypeEnum, groupName));

        GetAllUsersResponse dto = new GetAllUsersResponse(users, users.size());

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSpecificUser(@PathVariable UUID id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Validated User user) {

        return new ResponseEntity<>(userService.createUser(user),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody @Validated User user, @PathVariable UUID id) {

        return ResponseEntity.ok(userService.updateUser(user, id));
    }

    @GetMapping("/sync")
    public ResponseEntity<GetAllUsersResponse> syncUsers() {

        List<User> users = new ArrayList<>(userService.syncUsers());

        GetAllUsersResponse dto = new GetAllUsersResponse(users, users.size());

        return ResponseEntity.ok(dto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> assignGroups(@RequestBody AssignGroupsRequest dto, @PathVariable UUID id) {
        userService.assignGroups(id, dto.getGroups(), dto.getAction());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
