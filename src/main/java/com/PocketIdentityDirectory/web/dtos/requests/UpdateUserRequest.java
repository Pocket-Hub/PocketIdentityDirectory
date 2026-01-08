package com.PocketIdentityDirectory.web.dtos.requests;

import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignName;
import com.PocketIdentityDirectory.feign.dtos.helpers.SAPExtensionHelper;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.web.dtos.helpers.DTOCompanyAddress;
import com.PocketIdentityDirectory.web.dtos.helpers.DTOName;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class UpdateUserRequest {

    private UUID id;

    private String email;

    private String lastName;

    private DTOName name;

    private boolean userStatus;

    private UserType userType;

    private DTOCompanyAddress companyInfo;

    private Instant validFrom;

    private Instant validTo;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DTOName getName() {
        return name;
    }

    public void setName(DTOName name) {
        this.name = name;
    }

    public boolean isUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public DTOCompanyAddress getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(DTOCompanyAddress companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Instant getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Instant validFrom) {
        this.validFrom = validFrom;
    }

    public Instant getValidTo() {
        return validTo;
    }

    public void setValidTo(Instant validTo) {
        this.validTo = validTo;
    }
}
