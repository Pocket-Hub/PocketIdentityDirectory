package com.PocketIdentityDirectory.feign.dtos.models.groups;

import java.util.List;

public class IASGroupResponseList {

    private List<IASGroup> Resources;

    public List<IASGroup> getResources() {
        return Resources;
    }

    public void setResources(List<IASGroup> resources) {
        Resources = resources;
    }
}
