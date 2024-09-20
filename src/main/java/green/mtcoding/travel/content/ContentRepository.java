package green.mtcoding.travel.content;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
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

    public long countByContentTypeIdWithOption(String contentTypeId, String areaCode, String sigungucode) {
        StringBuilder jpql = new StringBuilder("select count(*) from Content where contentTypeId = :contentTypeId");
        if (areaCode != null && !areaCode.isEmpty() &&!"all".equals(areaCode)) {
            jpql.append(" and areaCode = :areaCode");
        }
        if(sigungucode != null && !sigungucode.isEmpty()) {
            jpql.append(" and sigunguCode = :sigungucode");
        }
        Query query = em.createQuery(jpql.toString());
        query.setParameter("contentTypeId", contentTypeId);

        if (areaCode != null && !areaCode.isEmpty() && !"all".equals(areaCode)) {
            query.setParameter("areaCode", areaCode);
        }
        if (sigungucode != null && !sigungucode.isEmpty()) {
            query.setParameter("sigungucode", sigungucode);
        }
        return (Long) query.getSingleResult();
    }

    public List<Content> findByContentTypeId(String contentTypeId, Pageable pageable) {
        Query query = em. createQuery("select c from Content c where c.contentTypeId = :contentTypeId", Content.class);
        query.setParameter("contentTypeId", contentTypeId);

        query.setFirstResult((int) pageable.getOffset());  // 시작 위치
        query.setMaxResults(pageable.getPageSize());       // 한 페이지에 표시할 최대 개수

        return query.getResultList();
    }

    public List<Content> findByContentTypeIdAndOption(String contentTypeId, String area, String sigunguCode,String sortBy, Pageable pageable) {
        StringBuilder queryStr = new StringBuilder("select c from Content c where c.contentTypeId = :contentTypeId and c.areaCode= :area");
        if (sigunguCode != null && !sigunguCode.isEmpty()) {
            queryStr.append(" and c.sigunguCode = :sigunguCode");
        }
        if (sortBy != null && !sortBy.isEmpty()) {
            if (sortBy.equals("createdTime")) {
                queryStr.append(" order by c.createdTime desc");
            } else if (sortBy.equals("viewCount")) {
                queryStr.append(" order by c.viewCount desc");
            }
        }
        Query query = em.createQuery(queryStr.toString(), Content.class);
        query.setParameter("contentTypeId", contentTypeId);
        query.setParameter("area", area);

        if (sigunguCode != null && !sigunguCode.isEmpty()) {
            query.setParameter("sigunguCode", sigunguCode);
        }
        query.setFirstResult((int) pageable.getOffset());  // 시작 위치
        query.setMaxResults(pageable.getPageSize());       // 한 페이지에 표시할 최대 개수

        return query.getResultList();
    }


    /*           hotPlace-start             */

    public List<Content> findHotPlaceAll() {
        return em.createQuery("select c from Content c order by c.viewCount desc", Content.class)
                .setFirstResult(0)
                .setMaxResults(20)
                .getResultList();
    }

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

    /*           hotPlace-end            */

}
