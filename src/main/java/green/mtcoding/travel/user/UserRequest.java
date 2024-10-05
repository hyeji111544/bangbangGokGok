package green.mtcoding.travel.user;


import green.mtcoding.travel.global.util.SHA256;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;

import java.security.NoSuchAlgorithmException;

//DTO
public class UserRequest {

    //로그인 기능 DTO
    @Getter
    public static class LoginDTO{

        @NotEmpty
        private String loginId;
        @NotEmpty
        private String password;

        LoginDTO(String loginId, String password) throws NoSuchAlgorithmException {
            this.loginId = loginId;
            this.password = SHA256.encrypt(password);
        }
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

        public User toEntity() throws NoSuchAlgorithmException {
            return User.builder().loginId(loginId).password(SHA256.encrypt(password)).nickName(nickName).email(email).phone(phone).build();
        }
    }

}
