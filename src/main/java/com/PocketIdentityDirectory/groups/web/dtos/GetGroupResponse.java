package com.PocketIdentityDirectory.groups.web.dtos;

import com.PocketIdentityDirectory.groups.models.Group;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetGroupResponse {

    private Group group;

    private Set<Member> members = new HashSet<>();

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
