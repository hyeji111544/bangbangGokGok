package green.mtcoding.travel.area;

import green.mtcoding.travel.global.util.Resp;
import green.mtcoding.travel.sigungu.Sigungu;
import green.mtcoding.travel.sigungu.SigunguResponse;
import green.mtcoding.travel.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AreaController {

    private final AreaService areaService;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */

    @GetMapping("/get-sigungu")
    public ResponseEntity<?> getSigungu(@RequestParam("area") String area) {
        AreaResponse.AreaDTO areaDTO = areaService.시군구리스트가져오기(area);
        return ResponseEntity.ok(Resp.ok(areaDTO));  }


    /*           hotPlace-end             */

    /*           festival-start             */
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
