package green.mtcoding.travel.content;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import green.mtcoding.travel.global.util.Resp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;


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
            @ModelAttribute ContentRequest.HotplaceDTO hotplaceDTO,
            HttpServletRequest request) {
        ContentResponse.HotPlacePageDTO hotPlacePageDTO = contentService.hotplaceList(hotplaceDTO);
        System.out.println(hotPlacePageDTO);
        request.setAttribute("model", hotPlacePageDTO);
        return "/hotplace/hotplace";
    }

    @GetMapping("/get-hotplace")
    public ResponseEntity<?> hotPlaceFilter(@ModelAttribute ContentRequest.HotplaceDTO hotplaceDTO    ) {
        ContentResponse.HotPlacePageDTO hotPlacePageDTO = contentService.hotplaceList(hotplaceDTO);
        return ResponseEntity.ok(Resp.ok(hotPlacePageDTO));
    }
    /*           hotPlace-end             */

    /*           festival-start             */
    @GetMapping("/festival")
    public String festival() {
        return "/festival/main";
    }

    // http://localhost:8080/hotplace?area=${areaCode}&sigungu=${sigunguCode}
    /* hotplace 로 보낸 코드
    @GetMapping("/hotplace")
    public String hotPlaceFromFestival(@RequestParam("area") String area, @RequestParam("sigungu") String sigungu) {
        System.out.println(area);
        System.out.println(sigungu);
        return "/hotplace/hotplace";
    }
     */
    /*           festival-end             */

    /*           info-start             */
    @GetMapping("/info")
    public String info(HttpServletRequest request) {
        ContentRequest.InfoRequestDTO infoRequestDTO = new ContentRequest.InfoRequestDTO();
        ContentResponse.infoListDTO infoListDTO= contentService.infoContentList(infoRequestDTO);
        request.setAttribute("model", infoListDTO);
        System.out.println(infoListDTO);
        return "/info/info";

    }
/*
    @GetMapping("/get-info")
    public ResponseEntity<?> Infoilter(
            @RequestParam(value = "area", required = false) String area,
            @RequestParam(value = "sigungu", required = false) String sigungu,
            @RequestParam(value = "sortBy", required = false) String sortBy
    ) {
        ContentResponse.infoListDTO infoListDTO= contentService.infoContentListWithArea("12", area, sigungu, sortBy);
        return ResponseEntity.ok(Resp.ok(infoListDTO));
    }

 */

    @GetMapping("/get-info")
    public ResponseEntity<?> Infoilter(@ModelAttribute ContentRequest.InfoRequestDTO requestDTO) {
        System.out.println(requestDTO);
        ContentResponse.infoListDTO infoListDTO= contentService.infoContentListWithArea(requestDTO);
        return ResponseEntity.ok(Resp.ok(infoListDTO));
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
