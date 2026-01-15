package com.PocketIdentityDirectory.groups.web.dtoMappers;

import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.groups.web.dtos.GetGroupResponse;
import com.PocketIdentityDirectory.groups.web.dtos.Member;
import com.PocketIdentityDirectory.users.models.User;

public class GroupMapper {


    public static GetGroupResponse mapGroupToGetGroupResponse(Group group){
        GetGroupResponse dto = new GetGroupResponse();
        dto.setId(group.getId());
        dto.setName(group.getName());
        dto.setDisplayName(group.getDisplayName());
        dto.setDescription(group.getDescription());

        for (User user : group.getMembers()) {
            Member member = new Member();
            member.setEmail(user.getEmail());
            member.setId(user.getId());
            member.setLastName(user.getName().getLastName());

            dto.addMembers(member);
        }

        return dto;
    }

}
