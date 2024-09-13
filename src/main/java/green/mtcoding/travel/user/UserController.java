package green.mtcoding.travel.user;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final HttpSession session;
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

    //로그인 로직
    @PostMapping("/login")
    public String login(@Valid UserRequest.LoginDTO loginDTO, Errors errors){
        //.setAttribute("-----------------0loginDTO", loginDTO);
        User sessionUser = userService.login(loginDTO);
        System.out.println("-----1"+ sessionUser.getLoginId());
        session.setAttribute("sessionUser", sessionUser);
        return "redirect:/";
    }
    //로그아웃
    @GetMapping("/logout")
    public String logout(){
        session.invalidate();
        return "redirect:/";
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
