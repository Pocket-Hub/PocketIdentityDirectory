package com.PocketIdentityDirectory.web.dtos.responses;

import java.util.ArrayList;
import java.util.List;

public class GetAllUsersResponse {

    private List<GetUserResponse> resources = new ArrayList<>();

    public List<GetUserResponse> getResources() {
        return resources;
    }

    public void setResources(List<GetUserResponse> resources) {
        this.resources = resources;
    }
}
