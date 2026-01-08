package com.PocketIdentityDirectory.feign.dtos.responses;


import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignName;

import java.util.List;
import java.util.UUID;

public class IASUserResponse {

    private UUID id;

    private String userName;

    private FeignName name;

    private String userType;

    private boolean active;

    private List<FeignEmail> emails;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public FeignName getName() {
        return name;
    }

    public void setName(FeignName name) {
        this.name = name;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<FeignEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<FeignEmail> emails) {
        this.emails = emails;
    }
}
