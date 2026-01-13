package com.PocketIdentityDirectory.feign.dtos.models.users.helpers;

import com.PocketIdentityDirectory.users.models.helpers.Status;

import java.time.Instant;

public class SAPExtensionHelper {

    private final boolean mailVerified = true;
    private Instant validFrom;
    private Instant validTo;
    private Status status;

    public SAPExtensionHelper(Instant validFrom, Instant validTo, Status status) {
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.status = status;
    }

    public boolean isMailVerified() {
        return mailVerified;
    }

    public Instant getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Instant validFrom) {
        this.validFrom = validFrom;
    }

    public Instant getValidTo() {
        return validTo;
    }

    public void setValidTo(Instant validTo) {
        this.validTo = validTo;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
