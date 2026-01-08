package com.PocketIdentityDirectory.feign.dtos.responses;

import java.util.List;

public class IASUserResponseList {

    private List<IASUserRsponse> Resources;

    public List<IASUserRsponse> getResources() {
        return Resources;
    }

    public void setResources(List<IASUserRsponse> resources) {
        this.Resources = resources;
    }
}
