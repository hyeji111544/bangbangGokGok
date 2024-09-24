package green.mtcoding.travel.review;

import green.mtcoding.travel.scrap.ScrapResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepository {

    private final EntityManager em;

    // 리뷰 쓰기
    public void reviewWrite(Review review) {
        Query query = em.createNativeQuery("insert into review_tb(user_id, is_deleted, context, content_id_content_id, rating)values(?1, false, ?2, ?3, ?4)");
        query.setParameter(1, review.getUser().getId());
        query.setParameter(2, review.getContext());
        query.setParameter(3, review.getContentId());
        query.setParameter(4, review.getRating());
        query.executeUpdate();
    }

    // 마이페이지 유저 정보 긁어오기
    public List<ReviewResponse.MypageUserDTO> userFindById(int id) {
        Query query = em.createNativeQuery("select u.id, u.nick_name, u.profile from user_tb u where u.id = ?");
        query.setParameter(1, id);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<ReviewResponse.MypageUserDTO> userInfo = mapper.list(query, ReviewResponse.MypageUserDTO.class);
        return userInfo;
    }

    // 마이페이지 내가 쓴 리뷰 조회하기
    public List<ReviewResponse.ReviewListDTO> reviewFindById(int id) {

        Query query = em.createNativeQuery("select r.id, c.content_id, c.content_type_id, c.title, c.addr1, r.context, r.created_at, r.rating  from review_tb r join content_tb c on r.content_id_content_id = c.content_id where r.user_id = ?");
        query.setParameter(1, id);
        query.setMaxResults(10);
        JpaResultMapper mapper = new JpaResultMapper();
        List<ReviewResponse.ReviewListDTO> reviewList = mapper.list(query, ReviewResponse.ReviewListDTO.class);
        return reviewList;
    }


}
