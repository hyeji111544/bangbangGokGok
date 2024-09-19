package green.mtcoding.travel.scrap;



import green.mtcoding.travel.user.User;
import green.mtcoding.travel.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@Import(ScrapRepository.class)
public class ScrapRepositoryTest {

    @Autowired
    private ScrapRepository scrapRepository;

    @Test
    public void scrapUpdateById_test(){
        int id = 2;
        scrapRepository.scrapUpdateById(id);
        int id2 = 1;
        List<ScrapResponse.ScrapListDTO> scrapList = scrapRepository.scrapFindByUserId(id2);
        System.out.println(scrapList);
    }

    @Test
    public void  scrapFindByUserId_test() {
        // give
        int id = 1;
        // when
        List<ScrapResponse.ScrapListDTO> scrapList = scrapRepository.scrapFindByUserId(id);

        // eye
        System.out.println(scrapList);
    }

}
