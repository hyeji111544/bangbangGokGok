package green.mtcoding.travel.content;

import green.mtcoding.travel.area.AreaService;

import green.mtcoding.travel.sigungu.SigunguService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import green.mtcoding.travel.global.util.Resp;
import green.mtcoding.travel.sigungu.SigunguService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;
    private final AreaService areaService;
    private final SigunguService sigunguService;

    /*           main-start             */
    @GetMapping("/")
    public String index() {
        return "/main/index";
    }
    /*           main-end             */

    /*           theme-start             */
    @GetMapping("/theme")
    public String theme() {
        return "/theme/theme";
    }
    /*           theme-end             */

    /*           region-start             */
    @GetMapping("/region")
    public String area() {
        return "/region/region";
    }

    /*           region-end             */



    /*           hotPlace-start             */
    @GetMapping("/hotplace")
    public String hotPlace(
            @RequestParam(value = "area", required = false) String area,
            @RequestParam(value = "sigungu", required = false) List<String> sigungu,
            HttpServletRequest request) {
        List<ContentResponse.HotPlaceDTO> hotPlaceDtos = contentService.핫플목록보기(area, sigungu);
        System.out.println(hotPlaceDtos);
        request.setAttribute("models", hotPlaceDtos);
        return "/hotplace/hotplace";
    }



   @GetMapping("/get-hotplace")
    public ResponseEntity<?> hotPlaceFilter(
           @RequestParam(value = "area", required = false) String area,
           @RequestParam(value = "sigungu", required = false) List<String> sigungu
            ) {
        List<ContentResponse.HotPlaceDTO> hotPlaceDtos = contentService.핫플목록보기(area, sigungu);
        return ResponseEntity.ok(Resp.ok(hotPlaceDtos));

    }

    /*           hotPlace-end             */

    /*           festival-start             */
    @GetMapping("/festival")
    public String festival() {
        return "/festival/festival";
    }
    /*           festival-end             */

    /*           info-start             */
    @GetMapping("/info")
    public String info(HttpServletRequest request) {
        ContentResponse.infoListDTO infoListDTO= contentService.infoContentList("12");
        request.setAttribute("model", infoListDTO);
        System.out.println(infoListDTO);

        return "/info/info";
    }
    /*           info-end             */

    /*           map-start             */
    @GetMapping("/tourmap")
    public String tourmap() {
        return "/tourmap/tourmap";
    }
    /*           map-end             */

    /*           user-start             */
    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}
