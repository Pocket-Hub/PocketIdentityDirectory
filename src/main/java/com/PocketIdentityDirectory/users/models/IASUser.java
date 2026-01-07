package com.PocketIdentityDirectory.users.models;

import com.PocketIdentityDirectory.users.models.helpers.Address;
import com.PocketIdentityDirectory.users.models.helpers.Name;
import com.PocketIdentityDirectory.users.models.helpers.userStatus;
import com.PocketIdentityDirectory.users.models.helpers.userType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class IASUser {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column
    @Embedded
    private Name name;

    @Column(unique = true, nullable = false)
    private String loginName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private userStatus userStatus;

    @Column
    @Enumerated(EnumType.STRING)
    private userType userType;

    @Column
    private String company;

    @Column
    @Embedded
    private Address address;

    public userType getUserType() {
        return userType;
    }

    public void setUserType(userType userType) {
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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

    public userStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(userStatus userStatus) {
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
