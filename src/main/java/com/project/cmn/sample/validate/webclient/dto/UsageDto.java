package com.project.cmn.sample.validate.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsageDto {

    @JsonProperty("prompt_tokens")
    private Integer promptTokens;

    @JsonProperty("completion_tokens")
    private Integer completionTokens;

    @JsonProperty("total_tokens")
    private Integer totalTokens;
}
