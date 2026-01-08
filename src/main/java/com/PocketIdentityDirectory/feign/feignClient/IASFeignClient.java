package com.PocketIdentityDirectory.feign.feignClient;

import com.PocketIdentityDirectory.feign.dtos.requests.CreateIASUserRequest;
import com.PocketIdentityDirectory.feign.dtos.responses.IASUserResponse;
import com.PocketIdentityDirectory.feign.dtos.responses.IASUserResponseList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(url = "https://amqssvkci.trial-accounts.ondemand.com/scim", configuration = FeignAuthConfig.class, name = "IAS")
public interface IASFeignClient {

    @GetMapping("/Users")
    IASUserResponseList getUsers();

    @PostMapping(value = "/Users", consumes = "application/scim+json")
    IASUserResponse createUser(@RequestBody CreateIASUserRequest dto);

    @DeleteMapping("/Users/{id}")
    void deleteUser (@PathVariable UUID id);

//    @PutMapping("/Users/{id}")
//    IASUserResponse updateUser(@RequestBody UpdateIASUserRequest dto);

}
