package com.PocketIdentityDirectory.groups.web;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<List<Group>> getGroups(){
        return ResponseEntity.ok(groupService.getGroups());
    }



}
