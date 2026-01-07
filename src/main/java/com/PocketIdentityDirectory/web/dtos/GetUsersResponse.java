package com.PocketIdentityDirectory.web.dtos;

import com.PocketIdentityDirectory.users.models.IASUser;

import java.util.List;

public class GetUsersResponse {

    private List<IASUser> resources;

    public List<IASUser> getResources() {
        return resources;
    }

    public void setResources(List<IASUser> resources) {
        this.resources = resources;
    }
}
