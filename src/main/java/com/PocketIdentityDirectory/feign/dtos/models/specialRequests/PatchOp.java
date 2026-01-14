package com.PocketIdentityDirectory.feign.dtos.models.specialRequests;

import java.util.List;

public class PatchOp {

    private final String[] schemas = new String[]{"urn:ietf:params:scim:api:messages:2.0:PatchOp"};

    private List<Operations> Operations;

    public String[] getSchemas() {
        return schemas;
    }

    public List<Operations> getOperations() {
        return Operations;
    }

    public void setOperations(List<Operations> operations) {
        Operations = operations;
    }
}
