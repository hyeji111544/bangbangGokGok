package green.mtcoding.travel.festival;

import green.mtcoding.travel.festivalInfo.FestivalInfo;
import green.mtcoding.travel.festivalInfo.FestivalInfoRepository;
import green.mtcoding.travel.festivalInfo.FestivalInfoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;

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

    @Test
    public void findByContentId_test() {
        // given
//        String contentId = "141105"; 없는 애
        String contentId = "734219"; // 더미

        // when
        FestivalInfo festivalInfo = festivalInfoRepository.findByContentId(contentId);

        // eye
        System.out.println(festivalInfo);

    }

    @Test
    public void save_test() {
        // given
        FestivalInfo festivalInfo = new FestivalInfo();
        festivalInfo.setContentId("141105");
        festivalInfo.setTitle("은지 축제");

        // when
        festivalInfoRepository.save(festivalInfo);

        // eye
        FestivalInfo festivalInfo1 = festivalInfoRepository.findByContentId("141105");
        System.out.println(festivalInfo1);
    }
}

