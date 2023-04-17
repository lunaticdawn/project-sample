package com.project.cmn.sample.validate.controller;

import com.project.cmn.http.util.ValidationUtils;
import com.project.cmn.sample.validate.dto.UserDto;
import com.project.cmn.sample.validate.dto.UserListDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
public class ValidateController {
    /**
     * Spring 의 @Validated 를 이용한 validation - List 만 포함한 파라미터를 validation
     *
     * @param param List 만 포함한 파라미터
     */
    @PostMapping("/validated/user/list")
    public void validatedUserListDto(@Validated @RequestBody UserListDto param) {

    }

    /**
     * Spring 의 @Validated 를 이용한 validation - 일반적인 파라미터를 validation
     *
     * @param param 일반적인 파라미터
     */
    @PostMapping("/validated/user")
    public void validatedUserDto(@Validated @RequestBody UserDto param) {

    }

    /**
     * Spring 의 @Validated 를 이용한 validation - 객체의 배열인 파라미터를 validation
     *
     * @param param 객체의 배열인 파라미터
     */
    @PostMapping("/validated/user/array")
    public void validatedUserDtoArray(@Validated @NotEmpty @RequestBody List<UserDto> param) {

    }

    /**
     * project-cmn 의 ValidationUtils 를 이용한 validation - List 만 포함한 파라미터를 validation
     *
     * @param param List 만 포함한 파라미터
     */
    @PostMapping("/util/validate/user/list")
    public void utilValidateUserListDto(@RequestBody UserListDto param) {
        ValidationUtils.validate(param);
    }

    /**
     * project-cmn 의 ValidationUtils 를 이용한 validation - 일반적인 파라미터를 validation
     *
     * @param param 일반적인 파라미터
     */
    @PostMapping("/util/validate/user")
    public void utilValidateUserDto(@RequestBody UserDto param) {
        ValidationUtils.validate(param);
    }

    /**
     * project-cmn 의 ValidationUtils 를 이용한 validation - 객체의 배열인 파라미터를 validation
     *
     * @param param 객체의 배열인 파라미터
     */
    @PostMapping("/util/validate/user/array")
    public void utilValidateUserDtoArray(@RequestBody List<UserDto> param) {
        ValidationUtils.validate(param);
    }
}
