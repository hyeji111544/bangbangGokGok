package green.mtcoding.travel.content;

import green.mtcoding.travel.area.Area;
import green.mtcoding.travel.area.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final AreaRepository areaRepository;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */
    public ContentResponse.infoListDTO infoContentList(String contentTypeId){
        long count = contentRepository.countByContentTypeId(contentTypeId);
        List<Content> contentList = contentRepository.findByContentTypeId(contentTypeId);
        List<Area> areaList = areaRepository.findAll();
        return new ContentResponse.infoListDTO(contentList, count, areaList);
    }
    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */
    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}
