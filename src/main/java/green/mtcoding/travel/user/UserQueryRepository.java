package green.mtcoding.travel.user;

import green.mtcoding.travel.review.Review;
import green.mtcoding.travel.scrap.Scrap;
import green.mtcoding.travel.scrap.ScrapResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserQueryRepository {

    private final EntityManager em;

    // 마이페이지 유저 정보 긁어오기
    public List<User> userFindById(int id) {
        Query query = em.createNativeQuery("select * from user_tb where id = ?");
        query.setParameter(1, id);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<User> userInfo = mapper.list(query, User.class);
        return userInfo;
    }

    // 마이페이지 유저 스크랩 긁어오기
    public List<UserResponse.MypageScrapDTO> scrapFindById(int id) {
        Query query = em.createNativeQuery("select s.id, s.is_scrap, c.content_id, c.content_type_id, c.title, c.addr1, c.first_image from user_tb u join scrap_tb s on u.id = s.user_id join content_tb c on s.content_content_id = c.content_id where u.id = ? and s.is_scrap = true");
        query.setParameter(1, id);
        query.setMaxResults(4);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<UserResponse.MypageScrapDTO> scrapList = mapper.list(query, UserResponse.MypageScrapDTO.class);
        return scrapList;
    }
    // 마이페이지 유저 스크랩 갯수
    public Long countScrapById(int id) {
        Query query = em.createNativeQuery("select count(*) from user_tb u join scrap_tb s on u.id = s.user_id where u.id = ?");
        query.setParameter(1, id);
        Long countScrap = (Long) query.getSingleResult();
        return countScrap;
    }
    // 마이페이지 유저 리뷰 긁어오기
    public List<UserResponse.MypageReviewDTO> reviewFindById(int id) {
        Query query = em.createNativeQuery("select r.id, c.content_id, c.content_type_id, c.title, c.addr1, r.context, r.created_at, r.rating from user_tb u join review_tb r on u.id = r.user_id join content_tb c on r.content_id_content_id = c.content_id where u.id = ?");
        query.setParameter(1, id);
        query.setMaxResults(4);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<UserResponse.MypageReviewDTO> reviewList = mapper.list(query, UserResponse.MypageReviewDTO.class);
        return reviewList;
    }
    // 마이페이지 유저 리뷰 개수
    public Long countReviewById(int id) {
        Query query = em.createNativeQuery("select count(*) from user_tb u join review_tb r on u.id = r.user_id where u.id = ?");
        query.setParameter(1, id);
        Long countReview = (Long) query.getSingleResult();
        return countReview;
    }


}
