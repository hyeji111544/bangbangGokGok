package green.mtcoding.travel.restourantInfo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RestaurantInfoRepository {

    private final EntityManager em;
    
}
