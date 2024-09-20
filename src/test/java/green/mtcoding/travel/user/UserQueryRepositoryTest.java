package green.mtcoding.travel.user;



import green.mtcoding.travel.scrap.Scrap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(UserQueryRepository.class)
public class UserQueryRepositoryTest {

    @Autowired
    private UserQueryRepository userQueryRepository;


}
