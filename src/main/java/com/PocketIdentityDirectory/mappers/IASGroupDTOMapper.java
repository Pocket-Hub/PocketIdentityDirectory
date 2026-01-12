package com.PocketIdentityDirectory.mappers;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.groups.helpers.ExtensionHelper;
import com.PocketIdentityDirectory.groups.models.Group;

public class IASGroupDTOMapper {

    public static Group mapIASGroupToGroup(IASGroup iasGroup){
        Group group = new Group();

        group.setId(iasGroup.getId());
        group.setName(iasGroup.getExtension().getName());
        group.setDisplayName(iasGroup.getDisplayName());
        group.setDescription(iasGroup.getExtension().getDescription());

        return group;
    }

    public static IASGroup mapGroupToIASGroup(Group group){
        IASGroup iasGroup = new IASGroup();

        iasGroup.setId(group.getId());
        iasGroup.setExtension(new ExtensionHelper(group.getName(), group.getDescription()));
        iasGroup.setDisplayName(group.getDisplayName());

        return iasGroup;
    }

}
