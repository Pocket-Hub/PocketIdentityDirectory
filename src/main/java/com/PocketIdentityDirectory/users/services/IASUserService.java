package com.PocketIdentityDirectory.users.services;

import com.PocketIdentityDirectory.users.repositories.IASUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IASUserService {

    private final IASUserRepository repository;

    @Autowired
    public IASUserService(IASUserRepository repository) {
        this.repository = repository;
    }




}
