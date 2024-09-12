package green.mtcoding.travel.sigungu;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SigunguRepository {

    private final EntityManager em;
    
}
