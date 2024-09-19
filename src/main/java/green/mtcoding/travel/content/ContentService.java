package green.mtcoding.travel.content;

import green.mtcoding.travel.area.Area;
import green.mtcoding.travel.area.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;


import java.util.ArrayList;
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

    public List<ContentResponse.HotPlaceDTO> 핫플목록보기(String area, List<String> sigungu) {
        List<Content> contents = new ArrayList<>();
        if(area == null && sigungu == null) {
            contents = contentRepository.findHotPlaceAll();
        } else if(area != null && sigungu == null) {
            contents = contentRepository.findHotPlaceByArea(area);
        } else if(area != null && sigungu != null) {
            contents = contentRepository.findHotPlaceByAreaAndSigungu(area, sigungu);
        }

        List<ContentResponse.HotPlaceDTO> hotPlaceDtos= new ArrayList<>();
        for(Content content : contents) {
            hotPlaceDtos.add(new ContentResponse.HotPlaceDTO(content));
        }
        return hotPlaceDtos;
    }
    

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
