package com.PocketIdentityDirectory.feign.dtos.models.groups.helpers;

public class ExtensionHelper {

    private String name;

    private String description;

    public ExtensionHelper(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
