package green.mtcoding.travel.sigungu;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import green.mtcoding.travel.global.util.Resp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class SigunguController {

    private final SigunguService sigunguService;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */

    @GetMapping("/get-sigungu")
    public ResponseEntity<?> getSigungu(@RequestParam("area") String area) {
        List<SigunguResponse.SigunguDTO> sigunguListDTO = sigunguService.시군구리스트가져오기(area);
        return ResponseEntity.ok(Resp.ok(sigunguListDTO));
    }

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
