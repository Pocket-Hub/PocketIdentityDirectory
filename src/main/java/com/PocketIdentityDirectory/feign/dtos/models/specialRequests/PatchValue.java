package com.PocketIdentityDirectory.feign.dtos.models.specialRequests;

public class PatchValue {

    private String value;

    public PatchValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
