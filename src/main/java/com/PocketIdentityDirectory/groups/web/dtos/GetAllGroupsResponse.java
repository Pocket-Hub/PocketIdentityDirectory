package com.PocketIdentityDirectory.groups.web.dtos;

import com.PocketIdentityDirectory.groups.models.Group;

import java.util.List;

public class GetAllGroupsResponse {

    private List<Group> resources;

    private int resourceCount;

    public GetAllGroupsResponse(List<Group> resources, int resourceCount) {
        this.resources = resources;
        this.resourceCount = resourceCount;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(int resourceCount) {
        this.resourceCount = resourceCount;
    }

    public List<Group> getResources() {
        return resources;
    }

    public void setResources(List<Group> resources) {
        this.resources = resources;
    }
}
