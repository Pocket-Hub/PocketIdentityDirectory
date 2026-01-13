package com.PocketIdentityDirectory.feign.dtos.models.patch;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    private String op;

    private String path;

    private List<PatchValue> value = new ArrayList<>();

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<PatchValue> getValue() {
        return value;
    }

    public void setValue(List<PatchValue> value) {
        this.value = value;
    }
}
