package com.PocketIdentityDirectory.feign.feignClient;

import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroup;
import com.PocketIdentityDirectory.feign.dtos.models.groups.IASGroupResponseList;
import com.PocketIdentityDirectory.feign.dtos.models.specialRequests.Bulk;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUser;
import com.PocketIdentityDirectory.feign.dtos.models.users.IASUserResponseList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(url = "https://anwcftbpd.trial-accounts.ondemand.com/scim", configuration = FeignConfig.class, name = "ias")
public interface IASFeignClient {

    @GetMapping("/Users?filter=userName ne \"\"")
    IASUserResponseList getUsers(@RequestParam(required = false) int count, @RequestParam(required = false) int startIndex);

    @GetMapping("/Users/{id}")
    IASUser getSpecificUser(@PathVariable UUID id);

    @PostMapping(value = "/Users", consumes = "application/scim+json")
    IASUser createUser(@RequestBody IASUser dto);

    @DeleteMapping("/Users/{id}")
    void deleteUser(@PathVariable UUID id);

    @PutMapping(value = "/Users/{id}", consumes = "application/scim+json")
    IASUser updateUser(@RequestBody IASUser dto, @PathVariable UUID id);

    @GetMapping("/Groups")
    IASGroupResponseList getGroups(@RequestParam(required = false) int count, @RequestParam(required = false) int startIndex);

    @GetMapping("/Groups/{id}")
    IASGroup getSpecificGroup(@PathVariable UUID id);

    @PostMapping(value = "/Groups", consumes = "application/scim+json")
    IASGroup createGroup(IASGroup group);

    @DeleteMapping("/Groups/{id}")
    void deleteGroup(@PathVariable UUID id);

    @PutMapping(value = "/Groups/{id}", consumes = "application/scim+json")
    IASGroup updateGroup(@RequestBody IASGroup iasGroup, @PathVariable UUID id);

    @PostMapping(value = "/Bulk", consumes = "application/scim+json")
    void bulkOp(@RequestBody Bulk bulk);

    @GetMapping("/Users")
    IASUserResponseList getSpecificUsers(@RequestParam String filter);


}
