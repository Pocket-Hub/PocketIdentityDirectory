package com.PocketIdentityDirectory.feign.dtos.models.groups;

import java.util.List;

public class IASGroupResponseList {

    private List<IASGroup> Resources;

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
        return Resources;
    }

    public void setResources(List<IASGroup> resources) {
        Resources = resources;
    }
}
