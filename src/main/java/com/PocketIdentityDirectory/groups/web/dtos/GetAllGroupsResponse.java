package com.PocketIdentityDirectory.groups.web.dtos;

import com.PocketIdentityDirectory.groups.models.Group;

import java.util.List;

public class GetAllGroupsResponse {

    private List<GetGroupResponse> resources;

    private int resourceCount;

    public GetAllGroupsResponse(List<GetGroupResponse> resources, int resourceCount) {
        this.resources = resources;
        this.resourceCount = resourceCount;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(int resourceCount) {
        this.resourceCount = resourceCount;
    }

    public List<GetGroupResponse> getResources() {
        return resources;
    }

    public void setResources(List<GetGroupResponse> resources) {
        this.resources = resources;
    }
}
