package com.PocketIdentityDirectory.groups.web.dtos;

import java.util.List;

public class GetAllGroupsResponse {

    private List<GetGroupResponse> resources;

    private long totalResourceCount;

    public GetAllGroupsResponse(List<GetGroupResponse> resources, long resourceCount) {
        this.resources = resources;
        this.totalResourceCount = resourceCount;
    }

    public long getTotalResourceCount() {
        return totalResourceCount;
    }

    public void setTotalResourceCount(long totalResourceCount) {
        this.totalResourceCount = totalResourceCount;
    }

    public List<GetGroupResponse> getResources() {
        return resources;
    }

    public void setResources(List<GetGroupResponse> resources) {
        this.resources = resources;
    }
}
