package com.PocketIdentityDirectory.feign.dtos.models.groups.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Member {

    private UUID value;

    private String type;

    @JsonProperty("$ref")
    private String ref;

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
