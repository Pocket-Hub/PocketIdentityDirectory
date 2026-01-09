package com.PocketIdentityDirectory.mappers;

import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.helpers.*;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.requests.UpdateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.responses.IASUserResponse;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.UserType;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.web.dtos.requests.UpdateUserRequest;

import java.util.List;

public class IASUsersDTOMapper {

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

    public static UpdateIASUserRequest mapUpdateUserRequestToUpdateIASUserRequest(UpdateUserRequest dto){
        UpdateIASUserRequest iasUser = new UpdateIASUserRequest();

        iasUser.setActive(dto.isUserStatus());
        iasUser.setId(dto.getId());
        iasUser.setName(new IASName(dto.getName().getFirstName(), dto.getName().getLastName()));
        iasUser.setAddresses(List.of(new IASAddress(dto.getCompanyInfo().getCountry(), dto.getCompanyInfo().getCity(), "work")));
        iasUser.setUserName(dto.getLoginName());
        iasUser.setEmails(List.of(new IASEmail(dto.getEmail(), true)));
        iasUser.setUserType(dto.getUserType());
        iasUser.setEntExtension(new EnterpriseExtensionHelper(dto.getCompanyInfo().getCompany()));
        iasUser.setExtension(new SAPExtensionHelper(dto.getValidFrom(), dto.getValidTo(), dto.getStatus(), List.of(new IASAddress(dto.getCompanyInfo().getCountry(), dto.getCompanyInfo().getCity(), "work"))));

        return iasUser;

    }

    public static CreateIASUserRequest mapCreateUserRequestToCreateIASUserRequest(CreateUserRequest dto){
        CreateIASUserRequest iasUser = new CreateIASUserRequest();

        iasUser.setUserName(dto.getLoginName());
        iasUser.setUserType(dto.getUserType());
        iasUser.setName(new IASName("", dto.getLastName()));
        iasUser.setEmails(new IASEmail[]{new IASEmail(dto.getEmail(), true)});

        return iasUser;
    }

}
