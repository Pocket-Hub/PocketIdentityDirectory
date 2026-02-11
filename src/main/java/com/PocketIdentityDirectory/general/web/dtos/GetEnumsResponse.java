package com.PocketIdentityDirectory.general.web.dtos;


import com.PocketIdentityDirectory.users.models.helpers.Country;
import com.PocketIdentityDirectory.users.models.helpers.Status;
import com.PocketIdentityDirectory.users.models.helpers.UserType;

public class GetEnumsResponse {

    private Country[] countries;

    private UserType[] userTypes;

    private Status[] userStatuses;

    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }

    public UserType[] getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(UserType[] userTypes) {
        this.userTypes = userTypes;
    }

    public Status[] getUserStatuses() {
        return userStatuses;
    }

    public void setUserStatuses(Status[] userStatuses) {
        this.userStatuses = userStatuses;
    }
}
