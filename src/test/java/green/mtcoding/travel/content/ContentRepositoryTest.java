package green.mtcoding.travel.content;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Import(ContentRepository.class)
@DataJpaTest
class ContentRepositoryTest {

    @Autowired
    private ContentRepository contentRepository;

    @Test
    void findByContentTypeId_test() {
        // given
        String contentTypeId = "12";

        // when
        List<Content> contentList = contentRepository.findByContentTypeId(contentTypeId);

        // then

    }




    /*           hotPlace-start             */
    @Test
    public void findHotPlaceFindAll() throws Exception {
        //given

        //when

        List<Content> contents = contentRepository.findHotPlaceAll();

        //eye
        System.out.println(contents);
    }

    @Test
    public void findHotPlaceByArea() throws Exception {
        //given
        String area = "1";

        //when
        List<Content> contents = contentRepository.findHotPlaceByArea(area);

        //eye
        System.out.println(contents);
    }

    @Test
    public void findHotPlaceByAreaAndSigungu() throws Exception {
        //given
        String area = "1";
        List<String> sigungu = Arrays.asList("1", "2");

        //when
        List<Content> contents = contentRepository.findHotPlaceByAreaAndSigungu(area, sigungu);

        //eye
        System.out.println(contents);
    }
    /*           hotPlace-end             */


}
