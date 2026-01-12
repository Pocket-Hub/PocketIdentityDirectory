package com.PocketIdentityDirectory.groups.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.UUID;


@Table(name = "user_groups")
@Entity
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Group {

    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String displayName;

    @Column
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
