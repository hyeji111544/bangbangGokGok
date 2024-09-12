package green.mtcoding.travel.area;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AreaRepository {

    private final EntityManager em;


    
}
