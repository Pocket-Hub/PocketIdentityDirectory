package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignName;
import com.PocketIdentityDirectory.feign.dtos.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.service.FeignService;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
import com.PocketIdentityDirectory.web.dtos.requests.UpdateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        FeignEmail email = new FeignEmail();
        email.setValue(dto.getEmail());
        email.setPrimary(true);

        FeignName name = new FeignName();
        name.setFamilyName(dto.getLastName());

        iasUser.setUserName(dto.getLoginName());
        iasUser.setUserType(dto.getUserType());
        iasUser.setActive(true);
        iasUser.setName(name);
        iasUser.setEmails(new FeignEmail[]{email});
        iasUser.setSchemas(new String[]{"urn:ietf:params:scim:schemas:core:2.0:User"});

        return feignService.createIASUser(iasUser);
    }

    public void deleteUser(UUID id){
        repository.deleteById(id);
        feignService.deleteUser(id);
    }

    public User updateUser(UpdateUserRequest dto){


        return null;
    }
}
