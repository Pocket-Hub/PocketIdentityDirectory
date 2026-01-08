package com.PocketIdentityDirectory.feign.dtos.helpers;


public class FeignEmail {

    private String value;

    private boolean primary;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }
}
