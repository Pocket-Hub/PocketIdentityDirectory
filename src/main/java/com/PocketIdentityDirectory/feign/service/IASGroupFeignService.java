package com.PocketIdentityDirectory.feign.service;


import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IASGroupFeignService {

    private final IASFeignClient client;

    @Autowired
    public IASGroupFeignService(IASFeignClient client) {
        this.client = client;
    }

    public List<IASGroup> getAllGroups(){
        return client.getGroups().getResources();
    }


}
