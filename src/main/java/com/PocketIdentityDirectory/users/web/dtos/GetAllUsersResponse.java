package com.PocketIdentityDirectory.users.web.dtos;

import com.PocketIdentityDirectory.users.models.User;

import java.util.List;

public class GetAllUsersResponse {

    private List<GetUserResponse> resources;

    private int resourceCount;

    public GetAllUsersResponse(List<GetUserResponse> resources, int resourceCount) {
        this.resources = resources;
        this.resourceCount = resourceCount;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(int resourceCount) {
        this.resourceCount = resourceCount;
    }

    public List<GetUserResponse> getResources() {
        return resources;
    }

    public void setResources(List<GetUserResponse> resources) {
        this.resources = resources;
    }
}
