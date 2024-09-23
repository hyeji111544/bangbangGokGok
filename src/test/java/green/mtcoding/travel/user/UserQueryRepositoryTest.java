package green.mtcoding.travel.user;



import green.mtcoding.travel.scrap.Scrap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@Import(UserQueryRepository.class)
public class UserQueryRepositoryTest {

    @Autowired
    private UserQueryRepository userQueryRepository;

    @Test
    public void test(){
        int id = 1;
        Long countScrap = userQueryRepository.countScrapById(id);
        List<UserResponse.MypageReviewDTO> reviewList = userQueryRepository.reviewFindById(id);
        System.out.println(reviewList);
        System.out.println(countScrap);
    }

    @Test
    public void test1(){
        int id = 1;
        List<UserResponse.MypageUserDTO> userInfo = userQueryRepository.userFindById(id);
        System.out.println(userInfo);
    }
}
