package com.PocketIdentityDirectory.users.web.dtos;

import java.util.List;
import java.util.UUID;

public class PatchOpRequest {

    private List<UUID> groups;

    public List<UUID> getGroups() {
        return groups;
    }

    public void setGroups(List<UUID> groups) {
        this.groups = groups;
    }
}
