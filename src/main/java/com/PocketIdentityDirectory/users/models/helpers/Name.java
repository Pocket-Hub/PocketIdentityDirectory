package com.PocketIdentityDirectory.users.models.helpers;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Name {

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
