package com.PocketIdentityDirectory.feign;

import com.PocketIdentityDirectory.feign.dtos.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.responses.IASUserRsponse;
import com.PocketIdentityDirectory.feign.dtos.responses.IASUserResponseList;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "https://amqssvkci.trial-accounts.ondemand.com/scim", configuration = BasicAuthConfig.class, name = "IAS")
public interface IASFeignClient {

    @GetMapping("/Users")
    IASUserResponseList getUsers();

    @PostMapping(value = "/Users", consumes = "application/scim+json")
    IASUserRsponse createUser(@RequestBody CreateIASUserRequest dto);

}
