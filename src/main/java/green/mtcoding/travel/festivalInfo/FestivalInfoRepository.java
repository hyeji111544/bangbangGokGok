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

    public List<FestivalInfoResponse.FestivalMainDTO> findAll() {
        String sql = """
                SELECT content_id, contenttypeid, event_start_date, eventenddate, eventplace, origin_img_url, title FROM festivalinfo_tb;
                """;
        Query query = em.createNativeQuery(sql);

        JpaResultMapper mapper = new JpaResultMapper();
        List<FestivalInfoResponse.FestivalMainDTO> festivalInfoList = mapper.list(query, FestivalInfoResponse.FestivalMainDTO.class);

        return festivalInfoList;

    }

}
