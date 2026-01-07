package com.PocketIdentityDirectory.feign.dtos;

import java.util.List;

public class IASUserRequestList {

    private List<IASUserRequest> Resources;

    public List<IASUserRequest> getResources() {
        return Resources;
    }

    public void setResources(List<IASUserRequest> resources) {
        this.Resources = resources;
    }
}
