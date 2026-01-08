package com.PocketIdentityDirectory.web.dtos.responses;

import com.PocketIdentityDirectory.users.models.User;

import java.util.List;

public class GetUsersResponse {

    private List<User> resources;

    public List<User> getResources() {
        return resources;
    }

    public void setResources(List<User> resources) {
        this.resources = resources;
    }
}
