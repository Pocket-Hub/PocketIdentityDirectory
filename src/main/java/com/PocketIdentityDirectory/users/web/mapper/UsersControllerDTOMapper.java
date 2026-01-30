package com.PocketIdentityDirectory.users.web.mapper;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.web.dtos.GetUserResponse;

public class UsersControllerDTOMapper {

    public static GetUserResponse mapUserToGetUserResponse(User user) {
        GetUserResponse dto = new GetUserResponse();

        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getName().getFirstName());
        dto.setLastName(user.getName().getLastName());
        dto.setLoginName(user.getLoginName());

        return dto;
    }

}
