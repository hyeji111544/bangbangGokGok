package green.mtcoding.travel.festival;

import green.mtcoding.travel.festivalInfo.FestivalInfoRepository;
import green.mtcoding.travel.festivalInfo.FestivalInfoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(FestivalInfoRepository.class)
public class FestivalInfoRepositoryTest {
    @Autowired
    private FestivalInfoRepository festivalInfoRepository;

    @Test
    public void findAll_test() {
        // given

        // when
        List<FestivalInfoResponse.FestivalMainDTO> festivalInfoList = festivalInfoRepository.findAll();

        // eye
        System.out.println(festivalInfoList.size());
        System.out.println(festivalInfoList.get(0));
    }
}

