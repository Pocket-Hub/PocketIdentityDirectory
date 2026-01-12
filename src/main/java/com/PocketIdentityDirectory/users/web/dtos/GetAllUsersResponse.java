package com.PocketIdentityDirectory.users.web.dtos;

import com.PocketIdentityDirectory.users.models.User;

import java.util.List;

public class GetAllUsersResponse {

    private List<User> resources;

    private int resourceCount;

    public GetAllUsersResponse(List<User> resources, int resourceCount) {
        this.resources = resources;
        this.resourceCount = resourceCount;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(int resourceCount) {
        this.resourceCount = resourceCount;
    }

    public List<User> getResources() {
        return resources;
    }

    public void setResources(List<User> resources) {
        this.resources = resources;
    }
}
