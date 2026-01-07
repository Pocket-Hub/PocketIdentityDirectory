package com.PocketIdentityDirectory.feign;

import com.PocketIdentityDirectory.feign.dtos.IASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.IASUserRequestList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://amqssvkci.trial-accounts.ondemand.com/scim", configuration = BasicAuthConfig.class, name = "IAS")
public interface IASFeignClient {

    @GetMapping("/Users")
    IASUserRequestList getUsers();


}
