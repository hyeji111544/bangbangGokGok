package green.mtcoding.travel.review;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepository {

    private final EntityManager em;

    // content_id 리뷰 가져오기
    public List<ReviewResponse.detailReviewDTO> reviewFindByContentId(String contentId) {
        Query query = em.createNativeQuery("select r.id, r.context, r.created_at, r.rating, u.nick_name, u.profile from review_tb r join user_tb u on r.user_id = u.id where r.content_id_content_id = ?1");
        query.setParameter(1, contentId);
        JpaResultMapper mapper = new JpaResultMapper();
        List<ReviewResponse.detailReviewDTO> detailReview = mapper.list(query, ReviewResponse.detailReviewDTO.class);
        return detailReview;
    }

    // 리뷰 쓰기
    public void reviewWrite(int contentId, String context, double rating, int id) {
        Query query = em.createNativeQuery("insert into review_tb(user_id, is_deleted, context, content_id_content_id, rating, created_at)values(?1, false, ?2, ?3, ?4, now())");
        query.setParameter(1, id);
        query.setParameter(2, context);
        query.setParameter(3, contentId);
        query.setParameter(4, rating);
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


    public Content findById(int id) {
        Query query = em.createNativeQuery("select * from content_tb  where content_id = ?");
        query.setParameter(1, id);
        JpaResultMapper mapper = new JpaResultMapper();
        Content content = (Content) mapper.list(query, Content.class);
        return content;
    }
}
