package com.PocketIdentityDirectory.web.dtos.responses;

import com.PocketIdentityDirectory.web.dtos.helpers.DTOCompanyAddress;
import com.PocketIdentityDirectory.web.dtos.helpers.DTOName;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GetUserResponse {

    private UUID id;

    private String email;

    private DTOName name;

    private String loginName;

    private boolean active;

    private String userType;

    private DTOCompanyAddress companyInfo;

    private Instant validFrom;

    private Instant validTo;

    public GetUserResponse(UUID id, String email, DTOName name, String loginName, boolean active, String userType, DTOCompanyAddress companyInfo, Instant validFrom, Instant validTo) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.loginName = loginName;
        this.active = active;
        this.userType = userType;
        this.companyInfo = companyInfo;
        this.validFrom = validFrom;
        this.validTo = validTo;
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
