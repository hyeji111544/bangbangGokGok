package green.mtcoding.travel.content;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ContentQueryRepository {

    private final EntityManager em;


}
