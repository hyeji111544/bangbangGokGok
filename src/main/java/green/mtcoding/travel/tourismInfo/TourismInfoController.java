package green.mtcoding.travel.tourismInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URISyntaxException;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TourismInfoController {

    private final TourismInfoService tourismInfoService;


    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    @GetMapping("/test")
    public String test() throws JsonProcessingException, URISyntaxException {
       tourismInfoService.getRequest();
       return "/info/detail";
    }
    /*
    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */
    @GetMapping("/info/detail")
    public String detail() {
        return "/info/detail";
    }
    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */
    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}
