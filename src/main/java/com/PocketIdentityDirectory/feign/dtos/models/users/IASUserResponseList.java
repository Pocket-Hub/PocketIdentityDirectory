package com.PocketIdentityDirectory.feign.dtos.models.users;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class IASUserResponseList {

    private List<IASUser> Resources = new ArrayList<>();

    private int totalResults;

    private int itemsPerPage;

    private int startIndex;

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public List<IASUser> getResources() {
        return Resources;
    }

    public void setResources(List<IASUser> resources) {
        this.Resources = resources;
    }
}
