package com.PocketIdentityDirectory.feign.dtos.models.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class IASUserResponseList {

    @JsonProperty("Resources")
    private List<IASUser> resources = new ArrayList<>();

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
        return resources;
    }

    public void setResources(List<IASUser> resources) {
        this.resources = resources;
    }
}
