package green.mtcoding.travel.tourismInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

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
    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */
    @GetMapping("/info/detail")
    public String detail(@RequestParam("contentId") String contentId, HttpServletRequest request) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException {
        TourismResponse.OpenApiDto model = tourismInfoService.getDetailContent(contentId);
        System.out.println("-----------------------------controller");
        System.out.println(model);
        request.setAttribute("model", model);
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
