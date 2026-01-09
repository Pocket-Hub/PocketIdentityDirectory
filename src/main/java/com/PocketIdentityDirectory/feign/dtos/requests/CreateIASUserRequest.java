package com.PocketIdentityDirectory.feign.dtos.requests;


import com.PocketIdentityDirectory.feign.dtos.helpers.IASEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.IASName;

public class CreateIASUserRequest {

    private String[] schemas;

    private String userName;

    private IASName name;

    private IASEmail[] emails;

    private boolean active;

    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String[] getSchemas() {
        return schemas;
    }

    public void setSchemas(String[] schemas) {
        this.schemas = schemas;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public IASName getName() {
        return name;
    }

    public void setName(IASName name) {
        this.name = name;
    }

    public IASEmail[] getEmails() {
        return emails;
    }

    public void setEmails(IASEmail[] emails) {
        this.emails = emails;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
