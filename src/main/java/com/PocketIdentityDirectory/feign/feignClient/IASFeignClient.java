package com.PocketIdentityDirectory.feign.feignClient;

import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.responses.IASUser;
import com.PocketIdentityDirectory.feign.dtos.IASUsersDTOs.responses.IASUserResponseList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(url = "https://amqssvkci.trial-accounts.ondemand.com/scim", configuration = FeignAuthConfig.class, name = "IAS")
public interface IASFeignClient {

    @GetMapping("/Users")
    IASUserResponseList getUsers();

    @PostMapping(value = "/Users", consumes = "application/scim+json")
    IASUser createUser(@RequestBody IASUser dto);

    @DeleteMapping("/Users/{id}")
    void deleteUser(@PathVariable UUID id);

    @PutMapping(value = "/Users/{id}", consumes = "application/scim+json")
    IASUser updateUser(@RequestBody IASUser dto, @PathVariable UUID id);

}
