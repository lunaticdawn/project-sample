package com.project.cmn.sample.validate.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ModelPermissionDto {
    @JsonProperty("id")
    private String id;

    @JsonProperty("object")
    private String object;

    @JsonProperty("created")
    private Long created;

    @JsonProperty("allow_create_engine")
    private boolean allowCreateEngine;

    @JsonProperty("allow_sampling")
    private boolean allowSampling;

    @JsonProperty("allow_logprobs")
    private boolean allowLogprobs;

    @JsonProperty("allow_search_indices")
    private boolean allowSearchIndices;

    @JsonProperty("allow_view")
    private boolean allowView;

    @JsonProperty("allow_fine_tuning")
    private boolean allowFineTuning;

    @JsonProperty("organization")
    private String organization;

    @JsonProperty("group")
    private String group;

    @JsonProperty("is_blocking")
    private boolean isBlocking;
}
