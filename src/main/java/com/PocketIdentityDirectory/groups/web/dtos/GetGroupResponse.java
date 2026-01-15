package com.PocketIdentityDirectory.groups.web.dtos;

import com.PocketIdentityDirectory.groups.models.Group;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class GetGroupResponse {

    private UUID id;

    private String name;

    private String displayName;

    private String description;

    private Set<Member> members = new HashSet<>();

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

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public void addMembers(Member member){
        members.add(member);
    }
}
