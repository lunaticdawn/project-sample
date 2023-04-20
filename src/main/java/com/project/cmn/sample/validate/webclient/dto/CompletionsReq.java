package com.project.cmn.sample.validate.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
public class CompletionsReq {
    @JsonProperty("model")
    private String model;

    @JsonProperty("prompt")
    private String prompt;

    @JsonProperty("suffix")
    private String suffix;

    @JsonProperty("max_tokens")
    private Integer maxTokens;

    @JsonProperty("temperature")
    private Double temperature;

    @JsonProperty("top_p")
    private Double topP;

    @JsonProperty("n")
    private Integer n;

    @JsonProperty("stream")
    private Boolean stream;

    @JsonProperty("logprobs")
    private Integer logprobs;

    @JsonProperty("echo")
    private Boolean echo;

    @JsonProperty("stop")
    private String[] stop;

    @JsonProperty("presence_penalty")
    private Double presencePenalty;

    @JsonProperty("frequency_penalty")
    private Double frequencyPenalty;

    @JsonProperty("best_of")
    private Integer bestOf;

    @JsonProperty("logit_bias")
    private Map<String, Object> logitBias;

    @JsonProperty("user")
    private String user;
}
