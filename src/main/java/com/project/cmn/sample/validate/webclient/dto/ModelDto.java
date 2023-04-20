package com.project.cmn.sample.validate.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ModelDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("object")
    private String object;

    @JsonProperty("created")
    private Long created;

    @JsonProperty("owned_by")
    private String ownedBy;

    @JsonProperty("permission")
    private List<ModelPermissionDto> permission;
}
