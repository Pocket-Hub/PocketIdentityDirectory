package com.PocketIdentityDirectory.feign.dtos.models.users;

import java.util.List;

public class IASUserResponseList {

    private List<IASUser> Resources;

    public List<IASUser> getResources() {
        return Resources;
    }

    public void setResources(List<IASUser> resources) {
        this.Resources = resources;
    }
}
