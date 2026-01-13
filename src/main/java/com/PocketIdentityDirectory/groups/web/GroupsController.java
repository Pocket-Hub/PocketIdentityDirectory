package com.PocketIdentityDirectory.groups.web;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.services.GroupService;
import com.PocketIdentityDirectory.groups.web.dtos.GetAllGroupsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
public class GroupsController {

    private final GroupService groupService;

    @Autowired
    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<GetAllGroupsResponse> getGroups(){
        List<Group> groups = groupService.getGroups();
        GetAllGroupsResponse dto = new GetAllGroupsResponse(groups, groups.size());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<Group> createGroup(@RequestBody @Validated Group group){

        return new ResponseEntity<>(groupService.createGroup(group), HttpStatus.CREATED);
    }


}
