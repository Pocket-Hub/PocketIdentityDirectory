package com.PocketIdentityDirectory.users.web.mapper;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.web.dtos.GetUserResponse;

public class UsersControllerDTOMapper {

    public static GetUserResponse mapUserToGetUserResponse(User user) {
        GetUserResponse dto = new GetUserResponse();

        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());
        dto.setLoginName(user.getLoginName());

        return dto;
    }

}
