package com.PocketIdentityDirectory.web.dtos.mappers;

import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.web.dtos.helpers.DTOCompanyAddress;
import com.PocketIdentityDirectory.web.dtos.helpers.DTOName;
import com.PocketIdentityDirectory.web.dtos.requests.UpdateUserRequest;
import com.PocketIdentityDirectory.web.dtos.responses.GetUserResponse;

public class UsersDTOMapper {

    public static GetUserResponse mapUserToGetUserResponse(User user){
        return new GetUserResponse(
                user.getId(),
                user.getEmail(),
                new DTOName(user.getFirstName(), user.getLastName()),
                user.getLoginName(),
                user.isUserStatus(),
                user.getUserType().toString().toLowerCase(),
                new DTOCompanyAddress(user.getCompany(), user.getCountry(), user.getCity()),
                user.getValidFrom(),
                user.getValidTo()
                );
    }


}
