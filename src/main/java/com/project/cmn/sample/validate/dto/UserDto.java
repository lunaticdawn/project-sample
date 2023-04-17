package com.project.cmn.sample.validate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Getter
@Setter
@ToString
public class UserDto {
    @NotBlank
    @JsonProperty("user_id")
    private String userId;

    @NotBlank
    @JsonProperty("user_nm")
    private String userNm;

    @NotBlank
    @Pattern(regexp = "^Y$|^N$", message = "사용여부는 Y 또는 N 이어야 합니다.")
    @JsonProperty("use_yn")
    private String useYn;

    @NotEmpty
    @Valid
    @JsonProperty("auth_list")
    private List<AuthDto> authList;
}
