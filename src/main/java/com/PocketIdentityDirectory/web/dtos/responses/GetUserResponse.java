package com.PocketIdentityDirectory.web.dtos.responses;

import com.PocketIdentityDirectory.users.models.helpers.Address;
import com.PocketIdentityDirectory.users.models.helpers.Email;
import com.PocketIdentityDirectory.users.models.helpers.Name;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUserResponse {

    private UUID id;

    private Email email;

    private Name name;

    private String loginName;

    private boolean active;

    private String userType;

    private String company;

    private Address address;

    public GetUserResponse(UUID id, Email email, Name name, String loginName, boolean active, String userType, String company, Address address) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.loginName = loginName;
        this.active = active;
        this.userType = userType;
        this.company = company;
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
