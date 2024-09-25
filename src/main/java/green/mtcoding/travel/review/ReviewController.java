package green.mtcoding.travel.review;

import green.mtcoding.travel.user.User;
import green.mtcoding.travel.user.UserResponse;
import green.mtcoding.travel.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final HttpSession session;
    private final ReviewService reviewService;
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
    /*           user-end             */

    /*           myPage-start             */
    @GetMapping("/api/my-review")
    public String myReview(HttpServletRequest request) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        ReviewResponse.MypageReviewDTO model = reviewService.mypageReviewList(sessionUser);
        request.setAttribute("model", model);
        return "/mypage/my-review";
    }

    @PostMapping("/api/review/write")
    public ResponseEntity<?> reviewWrite(@RequestParam("contentId") Integer contentId,
                                         @RequestParam("context") String context,
                                         @RequestParam("rating") double rating) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        reviewService.reviewWrite(contentId, context, rating, sessionUser);
        return ResponseEntity.ok("댓글이 성공적으로 저장되었습니다.");
    }
    /*           myPage-end             */

}
