package com.PocketIdentityDirectory.feign.dtos.models.specialRequests;

import java.util.UUID;

public class BulkOp {

    private String method;

    private UUID bulkId;

    private String path;

    private PatchOp data;

    public BulkOp(String method, UUID bulkId, String path, PatchOp data) {
        this.method = method;
        this.bulkId = bulkId;
        this.path = path;
        this.data = data;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public UUID getBulkId() {
        return bulkId;
    }

    public void setBulkId(UUID bulkId) {
        this.bulkId = bulkId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public PatchOp getData() {
        return data;
    }

    public void setData(PatchOp data) {
        this.data = data;
    }
}
