package com.PocketIdentityDirectory.users.models.helpers;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Email {

    private String emailValue;

    private boolean emailPrimary;

    public String getEmailValue() {
        return emailValue;
    }

    public void setEmailValue(String emailValue) {
        this.emailValue = emailValue;
    }

    public boolean isEmailPrimary() {
        return emailPrimary;
    }

    public void setEmailPrimary(boolean emailPrimary) {
        this.emailPrimary = emailPrimary;
    }
}
