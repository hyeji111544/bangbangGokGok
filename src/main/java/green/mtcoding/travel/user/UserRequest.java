package green.mtcoding.travel.user;


import jakarta.validation.constraints.NotEmpty;
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
}
