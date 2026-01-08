package com.PocketIdentityDirectory.feign.dtos.responses;

import java.util.List;

public class IASUserResponseList {

    private List<IASUserResponse> Resources;

    public List<IASUserResponse> getResources() {
        return Resources;
    }

    public void setResources(List<IASUserResponse> resources) {
        this.Resources = resources;
    }
}
