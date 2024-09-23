package green.mtcoding.travel.festivalInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class FestivalInfoRepository {

    private final EntityManager em;

    // 메인 대표 축제 3개용
    public List<FestivalInfoResponse.FestivalMainDTO> findAll() {
        String sql = """
                SELECT content_id, content_type_id, event_start_date, event_end_date, event_place, origin_img_url, title FROM festivalinfo_tb;
                """;
        Query query = em.createNativeQuery(sql);

        JpaResultMapper mapper = new JpaResultMapper();
        List<FestivalInfoResponse.FestivalMainDTO> festivalInfoList = mapper.list(query, FestivalInfoResponse.FestivalMainDTO.class);

        return festivalInfoList;

    }

    public FestivalInfo findByContentId(String contentId) {
        Query query = em.createQuery("select f from FestivalInfo f where f.contentId = :contentId", FestivalInfo.class);
        query.setParameter("contentId", contentId);

        // getSingleResult() -> 단건 조회라서 없으면 NoResultException 터짐 / query.getResultList() -> List 리턴
        FestivalInfo festivalInfo = (FestivalInfo) query.getSingleResult();
        return festivalInfo;
    }

    public void save(FestivalInfo festivalInfo) {
        em.persist(festivalInfo);
    }

}
