package com.PocketIdentityDirectory.users.models;

import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.users.models.helpers.CompanyInfo;
import com.PocketIdentityDirectory.users.models.helpers.Name;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class User {

    @Id
    private UUID id;

    @Column
    @Email(message = "Please enter a valid email!")
    private String email;

    @Embedded
    @Valid
    private Name name;

    @NotBlank(message = "Login name cannot be blank!")
    @Column(unique = true, nullable = false)
    private String loginName;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column
    private boolean active;

    @Column
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Embedded
    private CompanyInfo companyInfo = new CompanyInfo();

    @Column
    private Instant validFrom;

    @Column
    private Instant validTo;

    @ManyToMany
    private Set<Group> groups = new HashSet<>();

    @Column
    private Instant lastUpdate;

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public CompanyInfo getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(CompanyInfo companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Instant getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Instant validFrom) {
        this.validFrom = validFrom;
    }

    public Instant getValidTo() {
        return validTo;
    }

    public void setValidTo(Instant validTo) {
        this.validTo = validTo;
    }

    public void assignGroups(List<Group> groups) {
        this.groups.addAll(groups);
    }

    public void unassignGroups(List<Group> groups){
        groups.forEach(this.groups::remove);
    }
}
