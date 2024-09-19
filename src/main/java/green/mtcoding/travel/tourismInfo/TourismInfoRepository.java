package green.mtcoding.travel.tourismInfo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class TourismInfoRepository {

    private final EntityManager em;
    
}
