package com.PocketIdentityDirectory.users.web.dtos;

import com.PocketIdentityDirectory.users.models.helpers.Name;

import java.util.UUID;

public class GetUserResponse {

    private UUID id;

    private Name name;

    private String email;

    private String loginName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
