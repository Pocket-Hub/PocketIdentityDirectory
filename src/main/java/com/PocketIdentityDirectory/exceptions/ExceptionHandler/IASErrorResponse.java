package com.PocketIdentityDirectory.exceptions.ExceptionHandler;

public class IASErrorResponse {

    private String[] schemas;

    private int status;

    private String detail;

    public String[] getSchemas() {
        return schemas;
    }

    public void setSchemas(String[] schemas) {
        this.schemas = schemas;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
