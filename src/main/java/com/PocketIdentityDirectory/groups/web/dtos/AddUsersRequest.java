package com.PocketIdentityDirectory.groups.web.dtos;

import java.util.List;
import java.util.UUID;

public class AddUsersRequest {

    private List<UUID> users;

    public List<UUID> getUsers() {
        return users;
    }

    public void setUsers(List<UUID> users) {
        this.users = users;
    }
}
