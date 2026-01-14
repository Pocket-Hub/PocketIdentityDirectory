package com.PocketIdentityDirectory.feign.dtos.models.specialRequests;

import java.util.List;

public class Bulk {

    private final String[] schemas = new String[]{"urn:ietf:params:scim:api:messages:2.0:BulkRequest"};

    private List<BulkOp> Operations;


    public String[] getSchemas() {
        return schemas;
    }

    public List<BulkOp> getOperations() {
        return Operations;
    }

    public void setOperations(List<BulkOp> operations) {
        Operations = operations;
    }
}
