package com.PocketIdentityDirectory.users.web.dtos.helpers;

public class ResponseEmailHelper {

    private boolean primary;

    private String value;

    public ResponseEmailHelper(boolean primary, String value) {
        this.primary = primary;
        this.value = value;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
