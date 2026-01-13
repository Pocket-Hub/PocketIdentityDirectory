package com.PocketIdentityDirectory.feign.dtos.models.users.helpers;

import java.util.UUID;

public class IASUserGroup {

    private UUID value;

    public UUID getValue() {
        return value;
    }

    public void setValue(UUID value) {
        this.value = value;
    }
}
