package com.PocketIdentityDirectory.mappers;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.groups.helpers.ExtensionHelper;
import com.PocketIdentityDirectory.feign.dtos.models.groups.helpers.Member;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.users.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IASGroupDTOMapper {

    public static Group mapIASGroupToGroup(IASGroup iasGroup) {
        Group group = new Group();

        group.setId(iasGroup.getId());
        group.setName(iasGroup.getExtension().getName());
        group.setDisplayName(iasGroup.getDisplayName());
        group.setDescription(iasGroup.getExtension().getDescription());

        return group;
    }

    public static IASGroup mapGroupToIASGroup(Group group) {
        IASGroup iasGroup = new IASGroup();

        iasGroup.setId(group.getId());
        iasGroup.setExtension(new ExtensionHelper(group.getName(), group.getDescription()));
        iasGroup.setDisplayName(group.getDisplayName());
        Set<User> users = group.getMembers();


        if (users == null || users.isEmpty()){
            return iasGroup;
        }

        List<Member> members = new ArrayList<>();
        for (User user : users) {
            members.add(new Member(user.getId(), "User", "https://aztcpjece.trial-accounts.ondemand.com/scim/Users/" + user.getId()));
        }
        iasGroup.setMembers(members);


        return iasGroup;
    }

}
