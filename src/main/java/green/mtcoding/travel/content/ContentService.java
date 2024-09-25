package green.mtcoding.travel.content;

import green.mtcoding.travel.area.Area;
import green.mtcoding.travel.area.AreaRepository;
import green.mtcoding.travel.global.error.ex.Exception404;
import green.mtcoding.travel.global.error.ex.ExceptionApi404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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

    public ContentResponse.HotPlacePageDTO 핫플목록보기(ContentRequest.HotplaceDTO hotplaceDTO) {
        System.out.println(hotplaceDTO);
        int page = hotplaceDTO.getPage();
        String category = hotplaceDTO.getCategory();
        String area = hotplaceDTO.getArea();
        List<String> sigungu = hotplaceDTO.getSigungu();
        String keyword = hotplaceDTO.getKeyword();

        List<Content> contents = new ArrayList<>();
        String list = "";
        Long totalCount = 0L;
        int perPage = 20;
        int first = (page-1) * perPage;
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


        //리팩토링 필요
        //전체 리스트
        if (area == null && sigungu == null) {
            if (list.equals("ta")) {
                contents = contentRepository.findHotTaAll(first, perPage, keyword);
                totalCount = contentRepository.findHotTaAllCount(keyword);
            } else if (list.equals("food")) {
                contents = contentRepository.findHotFoodAll(first, perPage, keyword);
                totalCount = contentRepository.findHotFoodAllCount(keyword);
            }

            //지역 리스트
        } else if (area != null && sigungu == null) {
            if (list.equals("ta")) {
                contents = contentRepository.findHotTaByArea(area, first, perPage, keyword);
                totalCount = contentRepository.findHotTaByAreaCount(area, keyword);
            } else if (list.equals("food")) {
                contents = contentRepository.findHotFoodByArea(area, first, perPage, keyword);
                totalCount = contentRepository.findHotFoodByAreaCount(area, keyword);
            }

            //지역 + 시군구 상세지역 리스트
        } else if (area != null && sigungu != null) {
            if (list.equals("ta")) {
                contents = contentRepository.findHotTaByAreaAndSigungu(area, sigungu, first, perPage, keyword);
                totalCount = contentRepository.findHotTaByAreaAndSigunguCount(area, sigungu, keyword);
            } else if (list.equals("food")) {
                contents = contentRepository.findHotFoodByAreaAndSigungu(area, sigungu,first, perPage, keyword);
                totalCount = contentRepository.findHotFoodByAreaAndSigunguCount(area, sigungu, keyword);
            }

        }


      /*  List<ContentResponse.HotPlaceDTO> hotPlaceDtos = new ArrayList<>();
        for (Content content : contents) {
            hotPlaceDtos.add(new ContentResponse.HotPlaceDTO(content));
        }*/
        return new ContentResponse.HotPlacePageDTO(contents, perPage, page, totalCount, keyword);
    }
    

    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */

    /*           info-start             */

    public ContentResponse.infoListDTO infoContentList(ContentRequest.InfoRequestDTO requestDTO){
        Pageable pageable = PageRequest.of(requestDTO.getPage(), 16);
        long count = contentRepository.countByContentTypeIdWithOption(requestDTO.getContentTypeId(), requestDTO.getArea(), requestDTO.getSigungu());
        List<Content> contentList = contentRepository.findByContentTypeId(requestDTO.getContentTypeId(),requestDTO.getSortBy(), pageable);
        List<Area> areaList = areaRepository.findAll();
        return new ContentResponse.infoListDTO(contentList, count, areaList);
    }

    public ContentResponse.infoListDTO infoContentListWithArea(ContentRequest.InfoRequestDTO requestDTO){
        System.out.println("contentTypeId = " + requestDTO.getContentTypeId()+ "/ area = " + requestDTO.getArea()+ "/ sigungu = " + requestDTO.getSigungu()+ "/ sortBy = " + requestDTO.getSortBy());

        List<Content> contentList;
        long count = contentRepository.countByContentTypeIdWithOption(requestDTO.getContentTypeId(), requestDTO.getArea(), requestDTO.getSigungu());

        Pageable pageable = PageRequest.of(requestDTO.getPage(), 16);

        if(requestDTO.getArea().equals("all")){
            contentList = contentRepository.findByContentTypeId(requestDTO.getContentTypeId(),requestDTO.getSortBy(), pageable);
        }else {
            contentList = contentRepository.findByContentTypeIdAndOption(requestDTO.getContentTypeId(), requestDTO.getArea(), requestDTO.getSigungu(), requestDTO.getSortBy(), pageable);
        }
        if (contentList.isEmpty()) {
            throw new ExceptionApi404("결과가 없습니다.");
        }
        List<Area> areaList = new ArrayList<>();
        return new ContentResponse.infoListDTO(contentList, count,areaList);
    }


    /*           info-end             */

    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */
    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}
