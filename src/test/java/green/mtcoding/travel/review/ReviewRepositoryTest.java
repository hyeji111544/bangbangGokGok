package green.mtcoding.travel.review;



import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.scrap.ScrapRepository;
import green.mtcoding.travel.scrap.ScrapResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(ReviewRepository.class)
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void  reviewFindById_test(){
        int id = 1;
        List<ReviewResponse.ReviewListDTO> reviewList = reviewRepository.reviewFindById(id);
        System.out.println(reviewList);
    }

    @Test
    public void test2(){
        String id = "126289";
        List<ReviewResponse.detailReviewDTO> detailReview = reviewRepository.reviewFindByContentId(id);
        System.out.println(detailReview);
    }


}
