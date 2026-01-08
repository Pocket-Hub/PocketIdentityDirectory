package com.PocketIdentityDirectory.web;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.services.UserService;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.web.dtos.responses.GetUsersResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<GetUsersResponse> getUsers(){
        GetUsersResponse dto = new GetUsersResponse();
        dto.setResources(userService.getUsers());

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest dto){

        return new ResponseEntity<>(userService.createUser(dto), HttpStatus.CREATED);
    }

}
