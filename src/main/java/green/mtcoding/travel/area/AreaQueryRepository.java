package green.mtcoding.travel.area;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AreaQueryRepository {

    private final EntityManager em;


    
}
