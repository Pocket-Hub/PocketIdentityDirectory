package com.PocketIdentityDirectory.feign.dtos.mappers;

import com.PocketIdentityDirectory.feign.dtos.helpers.IASEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.IASAddress;
import com.PocketIdentityDirectory.feign.dtos.responses.IASUserResponse;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.UserType;

public class FeignDTOMapper {

    public static User mapFeignIASUserResponseToIASUser(IASUserResponse dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setLoginName(dto.getUserName());
        user.setFirstName(dto.getName().getGivenName());
        user.setLastName(dto.getName().getFamilyName());
        user.setUserType(UserType.valueOf(dto.getUserType().toUpperCase()));
        user.setUserStatus(dto.isActive());
        user.setEmail(dto.getEmails().stream().filter(IASEmail::isPrimary).toList().get(0).getValue());
        user.setValidFrom(dto.getExtension().getValidFrom());
        user.setValidTo(dto.getExtension().getValidTo());
        user.setLoginName(dto.getUserName());
        if (dto.getExtension().getAddresses() != null) {
            IASAddress address = dto.getExtension().getAddresses().stream().filter(e -> e.getType().equals("work")).toList().get(0);
            user.setCountry(address.getCountry());
            user.setCity(address.getLocality());
        }
        if (dto.getEnterpriseExtension() != null) {
            user.setCompany(dto.getEnterpriseExtension().getOrganization());
        }
        return user;
    }

}
