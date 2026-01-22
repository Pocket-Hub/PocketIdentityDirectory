package com.PocketIdentityDirectory.groups.web;

import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.services.GroupService;
import com.PocketIdentityDirectory.groups.web.dtoMappers.GroupMapper;
import com.PocketIdentityDirectory.groups.web.dtos.AddUsersRequest;
import com.PocketIdentityDirectory.groups.web.dtos.GetAllGroupsResponse;
import com.PocketIdentityDirectory.groups.web.dtos.GetGroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/groups")
@CrossOrigin
public class GroupsController {

    private final GroupService groupService;

    @Autowired
    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<GetAllGroupsResponse> getGroups(@RequestParam(required = false) String name, @RequestParam(required = false) String displayName) {
        List<Group> groups = groupService.filterGroups(name, displayName);
        List<GetGroupResponse> responses = new ArrayList<>();
        for (Group group : groups) {
            responses.add(GroupMapper.mapGroupToGetGroupResponse(group));
        }
        GetAllGroupsResponse dto = new GetAllGroupsResponse(responses, groups.size());
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<GetGroupResponse> createGroup(@RequestBody @Validated Group group) {

        return new ResponseEntity<>(GroupMapper.mapGroupToGetGroupResponse(groupService.createGroup(group)), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable UUID id) {
        groupService.deleteGroup(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GetGroupResponse> updateGroup(@PathVariable UUID id, @RequestBody @Validated Group group) {

        return ResponseEntity.ok(GroupMapper.mapGroupToGetGroupResponse(groupService.updateGroup(group, id)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<GetGroupResponse> addMembers(@PathVariable UUID id, @RequestBody AddUsersRequest dto) {
        Group grp = groupService.addMembers(id, dto.getUsers(), dto.getAction());

        return new ResponseEntity<>(GroupMapper.mapGroupToGetGroupResponse(grp), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetGroupResponse> getSpecificGroup(@PathVariable UUID id) {
        return new ResponseEntity<>(GroupMapper.mapGroupToGetGroupResponse(groupService.getGroupById(id)), HttpStatus.OK);
    }

}
