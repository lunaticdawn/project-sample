package com.project.cmn.sample.validate.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChoiceDto {
    @JsonProperty("index")
    private Integer index;

    @JsonProperty("text")
    private String text;

    @JsonProperty("logprobs")
    private String logprobs;

    @JsonProperty("finish_reason")
    private String finishReason;
}
