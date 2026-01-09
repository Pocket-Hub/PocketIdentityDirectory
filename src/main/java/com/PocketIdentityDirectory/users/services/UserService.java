package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.dtos.helpers.*;
import com.PocketIdentityDirectory.feign.dtos.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.requests.UpdateIASUserRequest;
import com.PocketIdentityDirectory.feign.service.FeignService;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.web.dtos.requests.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    private final FeignService feignService;

    @Autowired
    public UserService(UserRepository repository, FeignService feignService) {
        this.repository = repository;
        this.feignService = feignService;
    }

    public List<User> getUsers() {
        return repository.saveAll(feignService.getIASUsers());
    }

    public User createUser(CreateUserRequest dto) {
        CreateIASUserRequest iasUser = new CreateIASUserRequest();

        IASEmail email = new IASEmail(dto.getEmail(), true);

        IASName name = new IASName("", dto.getLastName());
        name.setFamilyName(dto.getLastName());

        iasUser.setUserName(dto.getLoginName());
        iasUser.setUserType(dto.getUserType());
        iasUser.setActive(true);
        iasUser.setName(name);
        iasUser.setEmails(new IASEmail[]{email});
        iasUser.setSchemas(new String[]{"urn:ietf:params:scim:schemas:core:2.0:User"});

        return feignService.createIASUser(iasUser);
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
        feignService.deleteUser(id);
    }

    public User updateUser(UpdateUserRequest dto) {
        UpdateIASUserRequest feignUser = new UpdateIASUserRequest();

        feignUser.setActive(dto.isUserStatus());
        feignUser.setId(dto.getId());
        feignUser.setName(new IASName(dto.getName().getFirstName(), dto.getName().getLastName()));
        feignUser.setAddresses(List.of(new IASAddress(dto.getCompanyInfo().getCountry(), dto.getCompanyInfo().getCity(), "work")));
        feignUser.setUserName(dto.getLoginName());
        feignUser.setEmails(List.of(new IASEmail(dto.getEmail(), true)));
        feignUser.setUserType(dto.getUserType());
        feignUser.setEntExtension(new EnterpriseExtensionHelper(dto.getCompanyInfo().getCompany()));
        feignUser.setExtension(new SAPExtensionHelper(dto.getValidFrom(), dto.getValidTo(), dto.getStatus(), List.of(new IASAddress(dto.getCompanyInfo().getCountry(), dto.getCompanyInfo().getCity(), "work"))));

        return feignService.updateUser(feignUser);
    }
}
