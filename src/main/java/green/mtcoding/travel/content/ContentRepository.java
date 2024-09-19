package green.mtcoding.travel.content;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ContentRepository {

    private final EntityManager em;


    public long countByContentTypeId(String contentTypeId) {
        Query query = em.createQuery("select count(*) from Content where contentTypeId = :contentTypeId");
        query.setParameter("contentTypeId", contentTypeId);
        return (Long) query.getSingleResult();
    }

    public List<Content> findByContentTypeId(String contentTypeId) {
        Query query = em. createQuery("select c from Content c where c.contentTypeId = :contentTypeId", Content.class);
        query.setParameter("contentTypeId", contentTypeId);
        query.setMaxResults(10);
        List<Content> contentList = query.getResultList();
        return contentList;
    }


    /*           hotPlace-start             */

    public List<Content> findHotPlaceByArea(String area) {
        return em.createQuery("select c from Content c where c.areaCode =:area order by viewCount desc", Content.class)
                .setParameter("area", area)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }

    public List<Content> findHotPlaceByAreaAndSigungu(String area, List<String> sigungu) {
        return  em.createQuery("select c from Content c where c.areaCode =:area and  c.sigunguCode in (:sigungu) order by viewCount desc", Content.class)
                .setParameter("area", area)
                .setParameter("sigungu", sigungu)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }


    public List<Content> findHotTaAll() {
        return em.createQuery("select c from Content c where c.cat1 = 'A01' and c.cat1='A01' and c.cat2<>'A208' order by c.viewCount desc", Content.class)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }

    public List<Content> findHotFoodAll() {
        return em.createQuery("select c from Content c where c.cat1 = 'A05' order by c.viewCount desc", Content.class)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }

    public List<Content> findHotTaByArea(String area) {
        return em.createQuery("select c from Content c where c.cat1 = 'A01' and c.cat1='A01' and c.cat2<>'A208' and c.areaCode=:area order by c.viewCount desc", Content.class)
                .setParameter("area", area)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }

    public List<Content> findHotFoodByArea(String area) {
        return em.createQuery("select c from Content c where c.cat1 = 'A05' and c.areaCode=:area order by c.viewCount desc", Content.class)
                .setParameter("area", area)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }

    public List<Content> findHotTaByAreaAndSigungu(String area, List<String> sigungu) {
        return em.createQuery("select c from Content c where c.cat1 = 'A01' and c.cat1='A01' and c.cat2<>'A208' and c.areaCode=:area and c.sigunguCode in (:sigungu) order by c.viewCount desc", Content.class)
                .setParameter("area", area)
                .setParameter("sigungu", sigungu)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }

    public List<Content> findHotFoodByAreaAndSigungu(String area, List<String> sigungu) {
        return em.createQuery("select c from Content c where c.cat1 = 'A05' and c.areaCode=:area and c.sigunguCode in (:sigungu)order by c.viewCount desc", Content.class)
                .setParameter("area", area)
                .setParameter("sigungu", sigungu)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }





    /*           hotPlace-end            */

}
