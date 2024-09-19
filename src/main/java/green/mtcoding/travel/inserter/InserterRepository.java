package green.mtcoding.travel.inserter;

import green.mtcoding.travel.area.Area;
import green.mtcoding.travel.sigungu.Sigungu;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class InserterRepository  {

    private final EntityManager em;

    @Transactional
    public <T> void saveAll(List<T> entities) {
        for (T entity : entities) {
            em.persist(entity);
        }
    }


    public List<Sigungu> findAllSigungu() {
        return em.createQuery("SELECT s FROM Sigungu s", Sigungu.class)
                .getResultList();
    }



    public Area findByCode(String areacode) {
        return em.createQuery("SELECT r FROM Area r WHERE r.code = :areacode", Area.class)
                .setParameter("areacode", areacode)
                .getSingleResult();
    }
}
