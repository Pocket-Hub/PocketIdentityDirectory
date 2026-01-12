package com.PocketIdentityDirectory.mappers;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
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

}
