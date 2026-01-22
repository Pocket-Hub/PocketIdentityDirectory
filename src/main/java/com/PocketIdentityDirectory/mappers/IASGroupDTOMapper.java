package com.PocketIdentityDirectory.mappers;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.groups.helpers.ExtensionHelper;
import com.PocketIdentityDirectory.feign.dtos.models.groups.helpers.Member;
import com.PocketIdentityDirectory.groups.models.Group;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class IASGroupDTOMapper {

    private final UserService userService;

    @Autowired
    public IASGroupDTOMapper(@Lazy UserService userService) {
        this.userService = userService;
    }

    public static IASGroup mapGroupToIASGroup(Group group) {
        IASGroup iasGroup = new IASGroup();

        iasGroup.setId(group.getId());
        iasGroup.setExtension(new ExtensionHelper(group.getName(), group.getDescription()));
        iasGroup.setDisplayName(group.getDisplayName());
        Set<User> users = group.getMembers();


        if (users == null || users.isEmpty()) {
            return iasGroup;
        }

        List<Member> members = new ArrayList<>();
        for (User user : users) {
            members.add(new Member(user.getId(), "User", "https://aztcpjece.trial-accounts.ondemand.com/scim/Users/" + user.getId()));
        }
        iasGroup.setMembers(members);


        return iasGroup;
    }

    public Group mapIASGroupToGroup(IASGroup iasGroup) {
        Group group = new Group();

        group.setId(iasGroup.getId());
        group.setName(iasGroup.getExtension().getName());
        group.setDisplayName(iasGroup.getDisplayName());
        group.setDescription(iasGroup.getExtension().getDescription());

        group.setLastUpdate(Instant.now());

        List<UUID> ids = new ArrayList<>();

        for (Member member : iasGroup.getMembers()) {
            if (member != null) {
                ids.add(member.getValue());
            }
        }

        group.assignMembers(userService.getUsersWithIDList(ids));

        return group;
    }

}
