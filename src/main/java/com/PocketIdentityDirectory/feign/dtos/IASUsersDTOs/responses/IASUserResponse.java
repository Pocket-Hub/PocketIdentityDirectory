package com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.responses;

import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.EnterpriseExtensionHelper;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.IASEmail;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.IASName;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.SAPExtensionHelper;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class IASUserResponse {

    private UUID id;

    private String userName;

    private IASName name;

    private String userType;

    private List<IASEmail> emails;

    private List<Object> groups;

    private boolean active;


    @JsonProperty("urn:ietf:params:scim:schemas:extension:sap:2.0:User")
    private SAPExtensionHelper extension;

    @JsonProperty("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User")
    private EnterpriseExtensionHelper enterpriseExtension;

    public EnterpriseExtensionHelper getEnterpriseExtension() {
        return enterpriseExtension;
    }

    public void setEnterpriseExtension(EnterpriseExtensionHelper enterpriseExtension) {
        this.enterpriseExtension = enterpriseExtension;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<IASEmail> getEmails() {
        return emails;
    }

    public void setEmails(List<IASEmail> emails) {
        this.emails = emails;
    }

    public List<Object> getGroups() {
        return groups;
    }

    public void setGroups(List<Object> groups) {
        this.groups = groups;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public SAPExtensionHelper getExtension() {
        return extension;
    }

    public void setExtension(SAPExtensionHelper extension) {
        this.extension = extension;
    }
}
