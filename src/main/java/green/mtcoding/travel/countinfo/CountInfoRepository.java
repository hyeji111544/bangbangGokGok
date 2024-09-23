package green.mtcoding.travel.countinfo;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CountInfoRepository {

    private final EntityManager em;
}
