package com.PocketIdentityDirectory.feign.dtos.models.groups;

import com.PocketIdentityDirectory.feign.dtos.models.groups.helpers.ExtensionHelper;
import com.PocketIdentityDirectory.feign.dtos.models.groups.helpers.Member;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IASGroup {

    private final String[] schemas = new String[]{"urn:ietf:params:scim:schemas:core:2.0:Group",
            "urn:sap:cloud:scim:schemas:extension:custom:2.0:Group"};

    private UUID id;

    @JsonProperty("urn:sap:cloud:scim:schemas:extension:custom:2.0:Group")
    private ExtensionHelper extension;

    private String displayName;

    private List<Member> members = new ArrayList<>();

    public String[] getSchemas() {
        return schemas;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ExtensionHelper getExtension() {
        return extension;
    }

    public void setExtension(ExtensionHelper extension) {
        this.extension = extension;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
