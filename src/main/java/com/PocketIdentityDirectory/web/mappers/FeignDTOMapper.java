package com.PocketIdentityDirectory.web.mappers;

import com.PocketIdentityDirectory.feign.dtos.responses.IASUserRsponse;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.users.models.IASUser;
import com.PocketIdentityDirectory.users.models.helpers.Email;
import com.PocketIdentityDirectory.users.models.helpers.Name;
import com.PocketIdentityDirectory.users.models.helpers.UserType;

public class FeignDTOMapper {

    public static IASUser mapFeignIASUserResponseToIASUser(IASUserRsponse dto){
         IASUser user = new IASUser();
         user.setId(dto.getId());
         user.setLoginName(dto.getUserName());
         Name name = new Name();
         name.setFirstName(dto.getName().getGivenName());
         name.setLastName(dto.getName().getFamilyName());
         user.setName(name);
         user.setUserType(UserType.valueOf(dto.getUserType().toUpperCase()));
         user.setUserStatus(dto.isActive());
        Email email = new Email();
        FeignEmail feignEmail = dto.getEmails().stream().filter(FeignEmail::isPrimary).toList().get(0);
        email.setEmailPrimary(feignEmail.isPrimary());
        email.setEmailValue(feignEmail.getValue());
        user.setEmail(email);

        return user;
    }

}
