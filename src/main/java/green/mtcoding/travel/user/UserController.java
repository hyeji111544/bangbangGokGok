package green.mtcoding.travel.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */
    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */

    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/login-form";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/join-form";
    }

    /*           user-end             */

    /*           myPage-start             */
    @GetMapping("/my-page")  //이름은 임시로 달아놨습니다. 원하시는대로 바꾸시면 됩니다
    public String myPage() {
        return "/mypage/my-page";
    }

    @GetMapping("/my-board")
    public String myBoard() {
        return "/mypage/my-board";
    }

    @GetMapping("/my-info")
    public String myInfo() {
        return "/mypage/my-info";
    }
    /*           myPage-end             */



}
