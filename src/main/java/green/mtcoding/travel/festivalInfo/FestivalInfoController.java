package green.mtcoding.travel.festivalInfo;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FestivalInfoController {

    private final FestivalInfoService festivalInfoService;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    /*           hotPlace-end             */

    /*           festival-start             */
    // 쿼리스트링 전달
    // http://localhost:8080/festival/main?
    @GetMapping("/festival/main")
    public String festival(HttpServletRequest request) {
        List<FestivalInfoResponse.FestivalMainDTO> festivalInfoList = festivalInfoService.목록보기();
        request.setAttribute("models", festivalInfoList);
        return "/festival/festival";
    }

    @GetMapping("/festival/{contentid}")
    public String festivalDetail() {
        return "";
    }
    /*           festival-end             */

    /*           info-start             */
    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */
    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}
