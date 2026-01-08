package com.PocketIdentityDirectory.feign.dtos.helpers;

import java.time.Instant;

public class ExtensionHelper {

    private Instant validFrom;

    private Instant validTo;

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
}
