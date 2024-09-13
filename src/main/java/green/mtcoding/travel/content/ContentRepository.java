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
}
