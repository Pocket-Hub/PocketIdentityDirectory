package com.PocketIdentityDirectory.web.dtos.requests;

import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.web.dtos.helpers.DTOCompanyAddress;
import com.PocketIdentityDirectory.web.dtos.helpers.DTOName;

import java.time.Instant;
import java.util.UUID;

public class UpdateUserRequest {

    private UUID id;

    private String email;

    private DTOName name;

    private String loginName;

    private boolean userStatus;

    private String userType;

    private DTOCompanyAddress companyInfo;

    private Instant validFrom;

    private Instant validTo;

    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
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
