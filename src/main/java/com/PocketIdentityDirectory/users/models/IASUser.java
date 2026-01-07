package com.PocketIdentityDirectory.users.models;

import com.PocketIdentityDirectory.users.models.helpers.*;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class IASUser {

    @Id
    private UUID id;

    @Embedded
    private Email email;

    @Column
    @Embedded
    private Name name;

    @Column(unique = true, nullable = false)
    private String loginName;

    @Column(nullable = false)
    private boolean userStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @Column
    private String company;

    @Column
    @Embedded
    private Address address;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
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

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
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
