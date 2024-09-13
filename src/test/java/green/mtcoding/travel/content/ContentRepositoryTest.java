package green.mtcoding.travel.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

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
}