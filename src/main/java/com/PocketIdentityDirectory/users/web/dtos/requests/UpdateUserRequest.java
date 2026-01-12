package com.PocketIdentityDirectory.users.web.dtos.requests;

import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.users.web.dtos.helpers.DTOCompanyAddress;
import com.PocketIdentityDirectory.users.web.dtos.helpers.DTOName;

import java.time.Instant;
import java.util.UUID;

public class UpdateUserRequest {

    private String email;

    private DTOName name;

    private String loginName;

    private UserType userType;

    private DTOCompanyAddress companyInfo;

    private Instant validFrom;

    private Instant validTo;

    private Status status;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
