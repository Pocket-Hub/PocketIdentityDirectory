package com.PocketIdentityDirectory.web;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.services.UserService;
import com.PocketIdentityDirectory.mappers.UsersDTOMapper;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.web.dtos.requests.UpdateUserRequest;
import com.PocketIdentityDirectory.web.dtos.responses.GetAllUsersResponse;
import com.PocketIdentityDirectory.web.dtos.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<GetAllUsersResponse> getUsers() {
        List<User> users = userService.getUsers();
        GetAllUsersResponse dto = new GetAllUsersResponse();

        for (User user : users) {
            dto.getResources().add(UsersDTOMapper.mapUserToGetUserResponse(user));
        }

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<GetUserResponse> createUser(@RequestBody CreateUserRequest dto) {

        return new ResponseEntity<>(
                UsersDTOMapper.mapUserToGetUserResponse(userService.createUser(dto)),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetUserResponse> updateUser(@RequestBody UpdateUserRequest dto) {

        return ResponseEntity.ok(UsersDTOMapper.mapUserToGetUserResponse(userService.updateUser(dto)));
    }


}
