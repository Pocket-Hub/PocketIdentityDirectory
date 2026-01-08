package com.PocketIdentityDirectory.feign.dtos.requests;


import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.Name;
import com.PocketIdentityDirectory.users.models.helpers.Email;

public class CreateIASUserRequest {

    private String[] schemas;

    private String userName;

    private Name name;

    private FeignEmail[] emails;

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

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public FeignEmail[] getEmails() {
        return emails;
    }

    public void setEmails(FeignEmail[] emails) {
        this.emails = emails;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
