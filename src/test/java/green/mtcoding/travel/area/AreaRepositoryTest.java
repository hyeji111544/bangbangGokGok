package green.mtcoding.travel.area;

import green.mtcoding.travel.sigungu.Sigungu;
import green.mtcoding.travel.sigungu.SigunguRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(AreaRepository.class)
@DataJpaTest
public class AreaRepositoryTest {

    @Autowired
    private AreaRepository areaRepository;

    @Test
    public void findByArea_test() throws Exception {
        //given
        String areaCode = "1";

        //when
        Area area = areaRepository.findByArea(areaCode);

        //eye
        System.out.println(area);


    }
}
