package com.PocketIdentityDirectory;

import com.PocketIdentityDirectory.groups.services.GroupService;
import com.PocketIdentityDirectory.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class GeneralController {

    private final UserService userService;
    private final GroupService groupService;

    @Autowired
    public GeneralController(UserService userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @PostMapping("/sync")
    public ResponseEntity<Void> sync(){
        groupService.syncGroups();
        userService.syncUsers();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
