package com.PocketIdentityDirectory.groups.web.dtos;

import com.PocketIdentityDirectory.groups.models.Group;

import java.util.List;

public class GetAllGroupsResponse {

    private List<Group> resources;

    public List<Group> getResources() {
        return resources;
    }

    public void setResources(List<Group> resources) {
        this.resources = resources;
    }
}
