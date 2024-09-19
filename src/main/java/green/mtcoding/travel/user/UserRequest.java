package green.mtcoding.travel.user;


import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

//DTO
public class UserRequest {

    //로그인 기능 DTO
    @Data
    public static class LoginDTO{

        @NotEmpty
        private String loginId;
        @NotEmpty
        private String password;
    }


    //회원가입 기능 DTO
    @Data
    public static class JoinDTO{

        @NotEmpty
        private String loginId;
        @NotEmpty
        private String password;
       // private String profile;
        @NotEmpty
        private String nickName;
        @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", message = "이메일 형식으로 작성해주세요")
        private String email;
        private String phone;

        public User toEntity() {
            return User.builder().loginId(loginId).password(password).nickName(nickName).email(email).phone(phone).build();
        }
    }

}
