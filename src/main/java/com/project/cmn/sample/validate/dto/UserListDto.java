package com.project.cmn.sample.validate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@ToString
public class UserListDto {
    @NotEmpty
    @Valid
    @JsonProperty("user_list")
    private List<UserDto> userList;
}
