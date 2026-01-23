package com.PocketIdentityDirectory.groups.models;

import com.PocketIdentityDirectory.users.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Table(name = "role_groups")
@Entity
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class Group {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Name cannot be blank!")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Display Name cannot be blank!")
    private String displayName;

    @Column
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "groups")
    private Set<User> members = new HashSet<>();

    @Column
    private Instant lastUpdate;

    public void assignMembers(List<User> users) {
        members.addAll(users);
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

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

    @PreRemove
    private void removeGroupsFromUsers() {
        for (User u : members) {
            u.getGroups().remove(this);
        }
    }

}
