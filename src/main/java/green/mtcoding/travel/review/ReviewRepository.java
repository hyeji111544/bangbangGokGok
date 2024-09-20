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
