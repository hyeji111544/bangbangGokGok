package green.mtcoding.travel.review;

import green.mtcoding.travel.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

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

    // 마이페이지 리뷰 리스트 조회
    public List<ReviewResponse.ReviewListDTO> mypageReviewList(User sessionUser) {
        // 1. 유저 세션으로 user_id 조회
        int id = sessionUser.getId();
        List<ReviewResponse.ReviewListDTO> reviewList = reviewRepository.reviewFindById(id);
        return reviewList;
    }

    /*           myPage-end             */
}
