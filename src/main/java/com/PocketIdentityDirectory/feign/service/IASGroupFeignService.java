package com.PocketIdentityDirectory.feign.service;


import com.PocketIdentityDirectory.feign.feignClient.IASFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IASGroupFeignService {

    private final IASFeignClient client;

    @Autowired
    public IASGroupFeignService(IASFeignClient client) {
        this.client = client;
    }


}
