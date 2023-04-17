package com.project.cmn.sample.validate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class AuthDto {
    @NotBlank
    @JsonProperty("auth_id")
    private String authId;

    @NotBlank
    @JsonProperty("auth_me")
    private String authNm;
}
