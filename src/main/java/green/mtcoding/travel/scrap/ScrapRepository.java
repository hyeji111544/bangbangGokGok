package green.mtcoding.travel.scrap;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.user.UserResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
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

    // 마이페이지 유저 정보 긁어오기
    public List<ScrapResponse.MypageUserDTO> userFindById(int id) {
        Query query = em.createNativeQuery("select u.id, u.nick_name, u.profile from user_tb u where u.id = ?");
        query.setParameter(1, id);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<ScrapResponse.MypageUserDTO> userInfo = mapper.list(query, ScrapResponse.MypageUserDTO.class);
        return userInfo;
    }

    // 기존 스크랩이 존재하는지 찾기
    public Boolean scrapFindByContentId(int userId, String contentId) {
        try {
            Query query = em.createNativeQuery("select  is_scrap from scrap_tb where user_id = ? and content_content_id = ?");
            query.setParameter(1, userId);
            query.setParameter(2, contentId);
            Boolean scrap = (Boolean) query.getSingleResult();
            return scrap;
        } catch (NoResultException e) {
            return null;
        }

    }

    // 기존 스크랩 상세보기에서 scrapId로 Off
    public void scrapOffById(int userId, String contentId) {
        Query query = em.createNativeQuery("update scrap_tb set is_scrap = false where user_id = ? and content_content_id = ?");
        query.setParameter(1, userId);
        query.setParameter(2, contentId);
        query.executeUpdate();
    }

    // 기존 스크랩 상세보기에서 scrapId로 On
    public void scrapOnById(int userId, String contentId) {
        Query query = em.createNativeQuery("update scrap_tb set is_scrap = true where user_id = ? and content_content_id = ?");
        query.setParameter(1, userId);
        query.setParameter(2, contentId);
        query.executeUpdate();
    }

    // 새로운 스크랩 상세보기에서 유저아이디 + contentId로 추가하기
    public void scrapInsertById(int userId, String contentId){
        Query query = em.createNativeQuery("insert into scrap_tb(is_scrap, user_id, content_content_id) values(true, ?, ?) ");
        query.setParameter(1, userId);
        query.setParameter(2, contentId);
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
