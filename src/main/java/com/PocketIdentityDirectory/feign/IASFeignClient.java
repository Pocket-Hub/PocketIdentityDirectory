package com.PocketIdentityDirectory.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://amqssvkci.trial-accounts.ondemand.com/scim", configuration = BasicAuthConfig.class, name = "IAS")
public interface IASFeignClient {




}
