package green.mtcoding.travel.content;

import green.mtcoding.travel.area.AreaService;
import green.mtcoding.travel.sigungu.SigunguService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String hotplace() {
        return "/hotplace/hotplace";
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
    public String info() {
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
