package com.PocketIdentityDirectory.web.dtos.mappers;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.web.dtos.responses.GetUserResponse;

public class UsersDTOMapper {

    public static GetUserResponse mapUserToGetUserResponse(User user){
        return new GetUserResponse(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getLoginName(),
                user.isUserStatus(),
                user.getUserType().toString().toLowerCase(),
                user.getCompany(),
                user.getAddress(),
                user.getValidFrom(),
                user.getValidTo()
                );
    }

}
