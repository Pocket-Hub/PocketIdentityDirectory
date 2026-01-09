package com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests;


import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.IASEmail;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.IASName;

public class CreateIASUserRequest {

    private final String[] schemas = new String[]{"urn:ietf:params:scim:schemas:core:2.0:User"};

    private String userName;

    private IASName name;

    private IASEmail[] emails;

    private final boolean active = true;

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

}
