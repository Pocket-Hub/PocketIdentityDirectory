package com.PocketIdentityDirectory.feign.dtos.models.groups;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class IASGroupResponseList {

    @JsonProperty("Resources")
    private List<IASGroup> resources = new ArrayList<>();

    private int totalResults;

    private int startIndex;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public List<IASGroup> getResources() {
        return resources;
    }

    public void setResources(List<IASGroup> resources) {
        this.resources = resources;
    }
}
