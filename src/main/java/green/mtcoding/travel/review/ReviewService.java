package green.mtcoding.travel.review;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.content.ContentRepository;
import green.mtcoding.travel.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ContentRepository contentRepository;

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
    public ReviewResponse.MypageReviewDTO mypageReviewList(User sessionUser) {
        // 1. 유저 세션으로 user_id 조회
        int id = sessionUser.getId();
        List<ReviewResponse.ReviewListDTO> reviewList = reviewRepository.reviewFindById(id);
        List<ReviewResponse.MypageUserDTO> userInfo = reviewRepository.userFindById(id);
        return new ReviewResponse.MypageReviewDTO(reviewList, userInfo);
    }

    // 리뷰 쓰기
    @Transactional
    public void reviewWrite(int contentId, String context, double rating, User sessionUser) {
        int id = sessionUser.getId();
        reviewRepository.reviewWrite(contentId, context, rating, id);
    }

    public List<ReviewResponse.detailReviewDTO> getReviewList(String contentId) {
        List<ReviewResponse.detailReviewDTO> reviewList = reviewRepository.reviewFindByContentId(contentId);
        return reviewList;
    }
    /*           myPage-end             */
}
