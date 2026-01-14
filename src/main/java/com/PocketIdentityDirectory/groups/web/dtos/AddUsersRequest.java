package com.PocketIdentityDirectory.groups.web.dtos;

import java.util.List;
import java.util.UUID;

public class AddUsersRequest {

    private List<UUID> users;

    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<UUID> getUsers() {
        return users;
    }

    public void setUsers(List<UUID> users) {
        this.users = users;
    }
}
