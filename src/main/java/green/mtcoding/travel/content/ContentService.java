package green.mtcoding.travel.content;

import green.mtcoding.travel.area.Area;
import green.mtcoding.travel.area.AreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public ContentResponse.HotPlacePageDTO 핫플목록보기(String category, String area, List<String> sigungu, int page) {
        List<Content> contents = new ArrayList<>();
        String list = "";
        Long totalCount = 0L;
        int perPage = 20;
        int first = page * perPage;
        boolean ajax = false;

        if (category.equals("touristAttractions")) {
            //ta는 tourist attraction의 약자
            list = "ta";
        } else if (category.equals("restaurants")) {
            list = "food";
        }

        //관광지는 대분류 cat1=A01 +  cat1=A02 & cat2!=A208
        //음식점은 대분류 cat1=A05
        //이렇게 분류코드 개수가 차이나서 아예 메서드를 따로 만든다.


        //전체 리스트
        if (area == null && sigungu == null) {
            if (list.equals("ta")) {
                contents = contentRepository.findHotTaAll(first, perPage);
                totalCount = contentRepository.findHotTaAllCount();
                System.out.println("ta임");
            } else if (list.equals("food")) {
                contents = contentRepository.findHotFoodAll(first, perPage);
                totalCount = contentRepository.findHotFoodAllCount();
            }

            //지역 리스트
        } else if (area != null && sigungu == null) {
            if (list.equals("ta")) {
                contents = contentRepository.findHotTaByArea(area, first, perPage);
                totalCount = contentRepository.findHotTaByAreaCount(area);
            } else if (list.equals("food")) {
                contents = contentRepository.findHotFoodByArea(area, first, perPage);
                totalCount = contentRepository.findHotFoodByAreaCount(area);
            }

            //지역 + 시군구 상세지역 리스트
        } else if (area != null && sigungu != null) {
            if (list.equals("ta")) {
                contents = contentRepository.findHotTaByAreaAndSigungu(area, sigungu, first, perPage);
                totalCount = contentRepository.findHotTaByAreaAndSigunguCount(area, sigungu);
            } else if (list.equals("food")) {
                contents = contentRepository.findHotFoodByAreaAndSigungu(area, sigungu,first, perPage);
                totalCount = contentRepository.findHotFoodByAreaAndSigunguCount(area, sigungu);
            }

        }


      /*  List<ContentResponse.HotPlaceDTO> hotPlaceDtos = new ArrayList<>();
        for (Content content : contents) {
            hotPlaceDtos.add(new ContentResponse.HotPlaceDTO(content));
        }*/
        return new ContentResponse.HotPlacePageDTO(contents, perPage, page, totalCount);
    }


    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */

    public ContentResponse.infoListDTO infoContentList(String contentTypeId) {
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
