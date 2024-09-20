package green.mtcoding.travel.review;



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
    public void ssTest(){
         Boolean a = (4.5 % 1 != 0);
        System.out.println(a);

    }


}
