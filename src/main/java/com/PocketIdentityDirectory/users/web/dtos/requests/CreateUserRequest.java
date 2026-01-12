package com.PocketIdentityDirectory.users.web.dtos.requests;

import com.PocketIdentityDirectory.users.models.helpers.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotBlank(message = "Last Name cannot be blank!")
    private String lastName;

    @Email(message = "Please provide a valid email.")
    private String email;

    @NotNull(message = "User Type cannot be null!")
    private UserType userType;

    @NotBlank(message = "Login Name cannot be blank!")
    private String loginName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
