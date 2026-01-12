package com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.responses;

import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.*;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class IASUser {

    private final String[] schemas = new String[]{"urn:ietf:params:scim:schemas:core:2.0:User", "urn:ietf:params:scim:schemas:extension:sap:2.0:User", "urn:ietf:params:scim:schemas:extension:enterprise:2.0:User"};

    private UUID id;

    private String userName;

    private IASName name;

    private UserType userType;

    private List<IASEmail> emails;

    private List<Object> groups;

    private boolean active;

    private List<IASAddress> addresses;

    @JsonProperty("urn:ietf:params:scim:schemas:extension:sap:2.0:User")
    private SAPExtensionHelper extension;

    @JsonProperty("urn:ietf:params:scim:schemas:extension:enterprise:2.0:User")
    private EnterpriseExtensionHelper enterpriseExtension;

    public String[] getSchemas() {
        return schemas;
    }

    public EnterpriseExtensionHelper getEnterpriseExtension() {
        return enterpriseExtension;
    }

    public void setEnterpriseExtension(EnterpriseExtensionHelper enterpriseExtension) {
        this.enterpriseExtension = enterpriseExtension;
    }

    public List<IASAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<IASAddress> addresses) {
        this.addresses = addresses;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
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
