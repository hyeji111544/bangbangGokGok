package green.mtcoding.travel.review;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.content.ContentRepository;
import green.mtcoding.travel.global.error.ex.ExceptionApi404;
import green.mtcoding.travel.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

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
    public void reviewWrite(ReviewRequest.SaveDTO saveDTO, User sessionUser) {
        //contentId 받은 걸로 Content가 존재 유무 확인
        //하나 만들어 줄 것
        Content contentPs = contentRepository.findById(saveDTO.getBoardId())
                .orElseThrow(() -> new ExceptionApi404("게시글을 찾을 수 없습니다."));


        //존재하면 조회한 Content를 전달해서 toEntity로 db에 저장
        Review review = saveDTO.toEntity(sessionUser, contentPs);
        reviewRepository.reviewWrite(review);
    }
    /*           myPage-end             */
}
