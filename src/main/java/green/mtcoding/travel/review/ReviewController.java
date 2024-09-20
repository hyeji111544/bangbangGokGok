package green.mtcoding.travel.review;

import green.mtcoding.travel.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final HttpSession session;
    private final ReviewService reviewService;

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
    /*           user-end             */

    /*           myPage-start             */
    @GetMapping("/api/my-review")
    public String myReview(HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        List<ReviewResponse.ReviewListDTO> reviewList = reviewService.mypageReviewList(sessionUser);
        request.setAttribute("models", reviewList);
        return "/mypage/my-review";
    }

    @GetMapping("/write")
    public String write() {
        return "/mypage/write";
    }
    /*           myPage-end             */

}
