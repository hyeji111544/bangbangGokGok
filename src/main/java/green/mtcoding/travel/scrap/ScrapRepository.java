package green.mtcoding.travel.scrap;

import green.mtcoding.travel.content.Content;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequiredArgsConstructor
@Repository
public class ScrapRepository {

    private final EntityManager em;

    // 스크랩 false로 업데이트하기
    public void scrapUpdateById(int id){
        Query query = em.createNativeQuery("update scrap_tb set is_scrap = false where id = ?1 ");
        query.setParameter( 1, id);
        query.executeUpdate();
    }

    // 스크랩 목록 가져오기
    public List<ScrapResponse.ScrapListDTO> scrapFindByUserId(int id){

        // Query query = em.createQuery("select s.id, s.isScrap,s.content.title, s.content.contentId, s.content.contentTypeId, s.content.addr1, s.content.firstImage from Scrap s where s.user.id = :userId and s.isScrap = true", Scrap.class);
        Query query = em.createNativeQuery("select s.id, s.is_scrap, s.content_content_id, c.addr1, c.content_type_id, c.title, c.first_image from scrap_tb s join user_tb u on s.user_id = u.id join content_tb c on s.content_content_id = c.content_id where u.id = ? and s.is_scrap = true");
        query.setParameter(id, id);
        query.setMaxResults(8);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<ScrapResponse.ScrapListDTO> scrapList = mapper.list(query, ScrapResponse.ScrapListDTO.class);

        return scrapList;

    }

}
