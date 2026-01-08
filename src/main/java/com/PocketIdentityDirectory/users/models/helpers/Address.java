package com.PocketIdentityDirectory.users.models.helpers;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {

    private String country;

    private String city;

    private boolean isConfirmed;

}
