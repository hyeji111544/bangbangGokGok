package green.mtcoding.travel.domain.mypage;

import green.mtcoding.travel.domain.region.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    private final RegionService regionService;

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

    @GetMapping("/my-review")
    public String myReview() {
        return "/mypage/my-review";
    }

    @GetMapping("/my-scrap")
    public String myScrab() {
        return "/mypage/my-scrap";
    }

    @GetMapping("/write")
    public String write() {
        return "/mypage/write";
    }
}
