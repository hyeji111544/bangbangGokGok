package green.mtcoding.travel.festivalInfo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class FestivalInfoRepository {

    private final EntityManager em;


}
