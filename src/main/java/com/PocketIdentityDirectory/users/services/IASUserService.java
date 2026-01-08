package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.IASFeignClient;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.Name;
import com.PocketIdentityDirectory.feign.dtos.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.responses.IASUserRsponse;
import com.PocketIdentityDirectory.users.models.IASUser;
import com.PocketIdentityDirectory.users.models.helpers.Email;
import com.PocketIdentityDirectory.users.repositories.IASUserRepository;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.web.mappers.FeignDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IASUserService {

    private final IASUserRepository repository;
    private final IASFeignClient feignClient;

    @Autowired
    public IASUserService(IASUserRepository repository, IASFeignClient feignClient) {
        this.repository = repository;
        this.feignClient = feignClient;
    }

    public List<IASUser> getUsers() {
        List<IASUserRsponse> feignUsers = feignClient.getUsers().getResources();
        System.out.println(feignUsers);
        List<IASUser> users = new ArrayList<>();
        for (IASUserRsponse feignUser : feignUsers) {

            users.add(FeignDTOMapper.mapFeignIASUserResponseToIASUser(feignUser));
        }
        repository.saveAll(users);
        return repository.findAll();
    }

    public IASUser createUser(CreateUserRequest dto){
        CreateIASUserRequest feignUser = new CreateIASUserRequest();
        feignUser.setUserName(dto.getLoginName());
        feignUser.setUserType(dto.getUserType());
        feignUser.setActive(true);
        Name name = new Name();
        name.setFamilyName(dto.getLastName());
        feignUser.setName(name);
        FeignEmail email = new FeignEmail();
        email.setValue(dto.getEmail());
        email.setPrimary(true);
        feignUser.setEmails(new FeignEmail[]{email});
        feignUser.setSchemas(new String[]{"urn:ietf:params:scim:schemas:core:2.0:User"});

        IASUserRsponse response = feignClient.createUser(feignUser);
        IASUser user = FeignDTOMapper.mapFeignIASUserResponseToIASUser(response);

        return user;
    }




}
