package green.mtcoding.travel.sigungu;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class SigunguRepository {

    private final EntityManager em;


    /*           hotPlace-start             */
    public List<Sigungu> findByArea(String area) {
        return em.createQuery("select s from Sigungu s join fetch s.area a where a.code =:area", Sigungu.class)
                .setParameter("area", area)
                .getResultList();
    }
    /*           hotPlace-end             */

}
