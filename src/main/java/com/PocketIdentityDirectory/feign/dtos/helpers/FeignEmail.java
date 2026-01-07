package com.PocketIdentityDirectory.feign.dtos.helpers;

import jakarta.persistence.Column;

public class FeignEmail {

    @Column(unique = true, nullable = false)
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
