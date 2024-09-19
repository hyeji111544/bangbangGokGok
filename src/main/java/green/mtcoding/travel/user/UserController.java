package green.mtcoding.travel.user;


import green.mtcoding.travel.global.util.Resp;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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


    //회원가입 폼으로
    @GetMapping("/join-form")
    public String joinForm() {

        return "/user/join-form";
    }
    //회원가입
    @PostMapping("/join")
    public String join(@Valid UserRequest.JoinDTO joinDTO, @RequestParam(value = "profile", required = false) MultipartFile profile , Errors errors) {

        // Validation 에러 체크
        if (errors.hasErrors()) {
            return "redirect:/join-form"; // 유효성 검사가 실패하면 다시 회원가입 폼으로
        }

        //insert 하는 모든 것들은 toEntitiy로 하면 된다.
        userService.registuser(joinDTO,profile);
        return "redirect:/login-form";

    }

    //닉네임 중복확인 컨트롤러
    @GetMapping("/user/LoingIdCheck")
    public ResponseEntity<Resp<Boolean>> LoingIdCheck(@RequestParam("loginId") String loginId) {
        boolean isSameloginId = userService.loginIdcheck(loginId);
        String message = isSameloginId ? "중복된 아이디입니다." : "사용할 수 있는 아이디입니다.";
        return ResponseEntity.ok((Resp<Boolean>) Resp.ok(isSameloginId, message));
    }
    // 닉네임 중복확인 컨트롤러
    @GetMapping("/user/NickNamecheck")
    public ResponseEntity<Resp<Boolean>> NickNamecheck(@RequestParam("nickName") String nickName) {
        boolean isSamenickName = userService.nickNamcheck(nickName);
        String message = isSamenickName ? "중복된 닉네임입니다." : "사용할 수 있는 닉네임입니다.";
        return ResponseEntity.ok((Resp<Boolean>) Resp.ok(isSamenickName, message));
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
