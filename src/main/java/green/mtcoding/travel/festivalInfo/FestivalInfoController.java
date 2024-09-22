package green.mtcoding.travel.festivalInfo;

import green.mtcoding.travel.global.util.Resp;
import green.mtcoding.travel.user.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FestivalInfoController {

    private final HttpSession session;
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
    @GetMapping("/festival/main")
    public String festival(HttpServletRequest request) {
        List<FestivalInfoResponse.FestivalMainDTO> festivalInfoList = festivalInfoService.목록보기();
        request.setAttribute("models", festivalInfoList);
        return "/festival/festival";
    }

    @GetMapping("/festival/detail/{contentId}")
    public String festivalDetail(@PathVariable("contentId") String contentId, HttpServletRequest request) {
        request.setAttribute("festivalContentId", contentId);
        // 축제 댓글 유저용
        User sessionUser = (User) session.getAttribute("sessionUser");

        return "/festival/festival-detail";
    }

    // api 로 받은 축제 정보 DB 에 저장하고 저장한 데이터 돌려주기
    @PostMapping("/festival/save-festival-data")
    public ResponseEntity<?> save(@RequestBody FestivalInfoRequest.SaveDTO saveDTO) {
        FestivalInfoResponse.FestivalDetailDTO detailDTO = festivalInfoService.saveFestivalData(saveDTO);
        return ResponseEntity.ok(Resp.ok(detailDTO));
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
