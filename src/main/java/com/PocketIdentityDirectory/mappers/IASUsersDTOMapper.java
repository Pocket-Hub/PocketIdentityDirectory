package com.PocketIdentityDirectory.mappers;

import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.dtos.models.users.helpers.*;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.models.helpers.CompanyInfo;
import com.PocketIdentityDirectory.users.models.helpers.Name;

import java.util.List;

public class IASUsersDTOMapper {

    public static User mapIASUserToUser(IASUser dto) {
        User user = new User();
        Name name = new Name(dto.getName().getGivenName(), dto.getName().getFamilyName());

        user.setId(dto.getId());
        user.setLoginName(dto.getUserName());
        user.setName(name);
        user.setType(dto.getUserType());
        user.setStatus(dto.getExtension().getStatus());
        user.setEmail(dto.getEmails().stream().filter(IASEmail::isPrimary).toList().get(0).getValue());
        user.setValidFrom(dto.getExtension().getValidFrom());
        user.setValidTo(dto.getExtension().getValidTo());
        user.setLoginName(dto.getUserName());
        user.setActive(dto.isActive());

        CompanyInfo companyInfo = new CompanyInfo();

        if (dto.getAddresses() != null) {
            IASAddress address = dto.getAddresses().stream().filter(e -> e.getType().equals("work")).toList().get(0);
            companyInfo.setCountry(address.getCountry());
            companyInfo.setCity(address.getLocality());
        }

        if (dto.getEnterpriseExtension() != null) {
            companyInfo.setCompany(dto.getEnterpriseExtension().getOrganization());
        }

        user.setCompanyInfo(companyInfo);

        return user;
    }


    public static IASUser mapUserToIASUser(User user) {
        IASUser iasUser = new IASUser();

        iasUser.setId(user.getId());

        iasUser.setUserName(user.getLoginName());

        IASName name = new IASName(user.getName().getLastName(), user.getName().getFirstName());
        iasUser.setName(name);

        iasUser.setUserType(user.getType());

        iasUser.setEmails(List.of(new IASEmail(user.getEmail(), true)));

        iasUser.setGroups(List.of(new Object()));

        iasUser.setActive("active".equalsIgnoreCase(user.getStatus().toString()));

        iasUser.setAddresses(List.of(new IASAddress(user.getCompanyInfo().getCountry(),
                user.getCompanyInfo().getCity(),
                "work")));

        SAPExtensionHelper ext = new SAPExtensionHelper(user.getValidFrom(),
                user.getValidTo(),
                user.getStatus());
        iasUser.setExtension(ext);

        iasUser.setEnterpriseExtension(new EnterpriseExtensionHelper(user.getCompanyInfo().getCompany()));

        return iasUser;
    }

}
