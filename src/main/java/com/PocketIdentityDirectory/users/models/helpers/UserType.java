package com.PocketIdentityDirectory.users.models.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserType {
    @JsonProperty("public")
    PUBLIC,
    @JsonProperty("employee")
    EMPLOYEE,
    @JsonProperty("customer")
    CUSTOMER,
    @JsonProperty("partner")
    PARTNER,
    @JsonProperty("external")
    EXTERNAL,
    @JsonProperty("onboardee")
    ONBOARDEE,
    @JsonProperty("alumni")
    ALUMNI

}
