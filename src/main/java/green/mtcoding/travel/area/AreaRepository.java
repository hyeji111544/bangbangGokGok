package green.mtcoding.travel.area;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@RequiredArgsConstructor
@Repository
public class AreaRepository {

    private final EntityManager em;

    public List<Area> findAll(){
        Query query = em.createQuery("SELECT a FROM Area a", Area.class);
        List<Area> areaList = query.getResultList();
        return areaList;
    }

    public List<Area> findAreaWithSigungu (String areaCode){
        Query query = em.createQuery("SELECT a FROM Area a left join a.sigungus s where a.code = :areaCode", Area.class);
        query.setParameter("areaCode", areaCode);
        System.out.println(query.getResultList());
        return query.getResultList();
    }

    
}
