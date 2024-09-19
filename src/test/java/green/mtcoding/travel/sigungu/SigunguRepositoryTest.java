package green.mtcoding.travel.sigungu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(SigunguRepository.class)
@DataJpaTest
class SigunguRepositoryTest {

    @Autowired
    SigunguRepository sigunguRepository;



    @Test
    public void findByArea_test() throws Exception {
    //given
    String area = "1";

    //when
    sigunguRepository.findByArea(area);
    //eye



    }




}