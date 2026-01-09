package com.PocketIdentityDirectory.feign.dtos.helpers;

import java.time.Instant;
import java.util.List;

public class SAPExtensionHelper {

    private Instant validFrom;

    private Instant validTo;

    private String status;

    private List<IASAddress> addresses;

    public SAPExtensionHelper(Instant validFrom, Instant validTo, String status, List<IASAddress> addresses) {
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.status = status;
        this.addresses = addresses;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<IASAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<IASAddress> addresses) {
        this.addresses = addresses;
    }
}
