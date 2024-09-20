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


    public List<Content> findHotTaAll(int first, int perPage) {
        return em.createQuery("select c from Content c where (c.cat1 = 'A01' or (c.cat1= 'A02' and (c.cat2<>'A0207' and c.cat2 <> 'A0208'))) order by c.viewCount desc", Content.class)
                .setFirstResult(first)
                .setMaxResults(perPage)
                .getResultList();
    }

    public Long findHotTaAllCount() {
        return em.createQuery("select count(c) from Content c where (c.cat1 = 'A01' or (c.cat1= 'A02' and (c.cat2<>'A0207' and c.cat2 <> 'A0208')))", Long.class)
                .getSingleResult();
    }



    public List<Content> findHotFoodAll(int first, int perPage) {
        return em.createQuery("select c from Content c where c.cat1 = 'A05' order by c.viewCount desc", Content.class)
                .setFirstResult(first)
                .setMaxResults(perPage)
                .getResultList();
    }

    public Long findHotFoodAllCount() {
        return em.createQuery("select count(c) from Content c where c.cat1 = 'A05'", Long.class)
                .getSingleResult();
    }

    public List<Content> findHotTaByArea(String area, int first,  int perPage) {
        return em.createQuery("select c from Content c where (c.cat1 = 'A01' or (c.cat1= 'A02' and (c.cat2<>'A0207' and c.cat2 <> 'A0208'))) and c.areaCode=:area order by c.viewCount desc", Content.class)
                .setParameter("area", area)
                .setFirstResult(first)
                .setMaxResults(perPage)
                .getResultList();
    }

    public Long findHotTaByAreaCount(String area) {
        return em.createQuery("select count(c) from Content c where (c.cat1 = 'A01' or (c.cat1= 'A02' and (c.cat2<>'A0207' and c.cat2 <> 'A0208'))) and c.areaCode=:area", Long.class)
                .setParameter("area", area)
                .getSingleResult();
    }

    public List<Content> findHotFoodByArea(String area, int first,  int perPage) {
        return em.createQuery("select c from Content c where c.cat1 = 'A05' and c.areaCode=:area order by c.viewCount desc", Content.class)
                .setParameter("area", area)
                .setFirstResult(first)
                .setMaxResults(perPage)
                .getResultList();
    }
    public Long findHotFoodByAreaCount(String area) {
        return em.createQuery("select count(c) from Content c where c.cat1 = 'A05' and c.areaCode=:area", Long.class)
                .setParameter("area", area)
                .getSingleResult();
    }

    public List<Content> findHotTaByAreaAndSigungu(String area, List<String> sigungu, int first,  int perPage) {
        return em.createQuery("select c from Content c where (c.cat1 = 'A01' or (c.cat1= 'A02' and (c.cat2<>'A0207' and c.cat2 <> 'A0208'))) and c.areaCode=:area and c.sigunguCode in (:sigungu) ", Content.class)
                .setParameter("area", area)
                .setParameter("sigungu", sigungu)
                .setFirstResult(first)
                .setMaxResults(perPage)
                .getResultList();
    }
    public Long findHotTaByAreaAndSigunguCount(String area, List<String> sigungu) {
        return em.createQuery("select count(c) from Content c where (c.cat1 = 'A01' or (c.cat1= 'A02' and (c.cat2<>'A0207' and c.cat2 <> 'A0208'))) and c.areaCode=:area and c.sigunguCode in (:sigungu)", Long.class)
                .setParameter("area", area)
                .setParameter("sigungu", sigungu)
                .getSingleResult();
    }

    public List<Content> findHotFoodByAreaAndSigungu(String area, List<String> sigungu, int first,  int perPage) {
        return em.createQuery("select c from Content c where c.cat1 = 'A05' and c.areaCode=:area and c.sigunguCode in (:sigungu)order by c.viewCount desc", Content.class)
                .setParameter("area", area)
                .setParameter("sigungu", sigungu)
                .setFirstResult(first)
                .setMaxResults(perPage)
                .getResultList();
    }
    public Long findHotFoodByAreaAndSigunguCount(String area, List<String> sigungu) {
        return em.createQuery("select count(c) from Content c where c.cat1 = 'A05' and c.areaCode=:area and c.sigunguCode in (:sigungu)", Long.class)
                .setParameter("area", area)
                .setParameter("sigungu", sigungu)
                .getSingleResult();
    }







    /*           hotPlace-end            */

}
