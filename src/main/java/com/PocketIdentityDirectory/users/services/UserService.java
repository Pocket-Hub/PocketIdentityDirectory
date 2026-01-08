package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.feign.dtos.helpers.FeignEmail;
import com.PocketIdentityDirectory.feign.dtos.helpers.FeignName;
import com.PocketIdentityDirectory.feign.dtos.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.service.FeignService;
import com.PocketIdentityDirectory.users.models.User;
import com.PocketIdentityDirectory.users.repositories.UserRepository;
import com.PocketIdentityDirectory.web.dtos.requests.CreateUserRequest;
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
        repository.saveAll(feignService.getIASUsers());
        return repository.findAll();
    }

    public User createUser(CreateUserRequest dto) {
        CreateIASUserRequest feignUser = new CreateIASUserRequest();
        feignUser.setUserName(dto.getLoginName());
        feignUser.setUserType(dto.getUserType());
        feignUser.setActive(true);
        FeignName name = new FeignName();
        name.setFamilyName(dto.getLastName());
        feignUser.setName(name);
        FeignEmail email = new FeignEmail();
        email.setValue(dto.getEmail());
        email.setPrimary(true);
        feignUser.setEmails(new FeignEmail[]{email});
        feignUser.setSchemas(new String[]{"urn:ietf:params:scim:schemas:core:2.0:User"});

        return repository.save(feignService.createIASUser(feignUser));
    }

    public void deleteUser(UUID id){
        feignService.deleteUser(id);
        repository.deleteById(id);
    }
}
