package com.project.cmn.sample.validate.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ModelsRes {
    @JsonProperty("object")
    private String object;

    @JsonProperty("data")
    private List<ModelDto> data;
}
