# 파라미터의 정합성을 체크하기 위한 validation

## 예제에 쓰일 객체

### AuthDto
```java

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
```

### UserDto
```java

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
    @Pattern(regexp = "^Y|N$", message = "사용여부는 Y 또는 N 이어야 합니다.")
    @JsonProperty("use_yn")
    private String useYn;

    @NotEmpty
    @Valid
    @JsonProperty("auth_list")
    private List<AuthDto> authList;
}
```

### UserListDto
```java

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
```

## Spring 의 @Validated 사용
### 사용법
    - 검증할 argument 앞에 @Validated 를 선언
    - 검증할 그룹 지정 가능
    - 검증할 argument 내의 List 타입을 검증해야 하는 경우에는 List 타입에 @Valid 를 선언
    - List 타입의 argument 는 검증하지 못함
    - org.springframework.validation.BindException 발생

### 예제
```java

    @PostMapping("/validated/user")
    public void validatedUserDto(@Validated @RequestBody UserDto param) {

    }
```

위와 같이 구현하고 아래와 같이 호출한 경우 - 체크가 됨

```

POST http://localhost:8080/validated/user
Content-Type: application/json

{
  "user_id": "userId",
  "use_yn": "A",
  "auth_list": [
    {
      "auth_id": "authId"
    }
  ]
}
```

```java

    @PostMapping("/validated/user/array")
    public void validatedUserDtoArray(@Validated @NotEmpty @RequestBody List<UserDto> param) {

    }
```

위와 같이 구현하고 아래와 같이 호출한 경우 - 체크가 안됨

```

POST http://localhost:8080/validated/user/array
Content-Type: application/json

[
  {
    "user_id": "userId",
    "use_yn": "A",
    "auth_list": [
      {
        "auth_id": "authId"
      }
    ]
  }
]
```

위와 같은 경우 아래와 같이 구현하여 체크가 가능하게 할 수 있음

```java

    @PostMapping("/validated/user/list")
    public void validatedUserListDto(@Validated @RequestBody UserListDto param) {

    }
```

위와 같이 구현하고 아래와 같이 호출한 경우 - 체크가 됨

```

POST http://localhost:8080/validated/user/list
Content-Type: application/json

{
  "user_list": [
    {
      "user_id": "userId",
      "use_yn": "A",
      "auth_list": [
        {
          "auth_id": "authId"
        }
      ]
    }
  ]
}
```

## project-cmn 의 ValidationUtils 사용
### 사용법
    - 검증할 argument 를 대상으로 다음과 같이 사용
    - 기타 사용법은 Spring 의 @Validated 와 유사

```java

    @PostMapping("/util/validate/user/array")
    public void utilValidateUserDtoArray(@RequestBody List<UserDto> param) {
        ValidationUtils.validate(param);
    }
```

    - 호출하여 검증하므로 검증 시점을 구현자가 정할 수 있음
    - 검증할 그룹 지정 가능
    - List 타입의 argument 도 검증 가능
    - javax.validation.ConstraintViolationException 발생