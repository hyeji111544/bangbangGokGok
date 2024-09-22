package green.mtcoding.travel.tourismInfo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TourismInfoService {

    private final TourismInfoRepository tourismInfoRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    public String getRequest() {
        // 요청을 보낼 URL
        String apiUrl1 = "https://apis.data.go.kr/B551011/KorService1/detailCommon1"
                //인증키
                + "?serviceKey=guF8R5Fvce%2B4pE1ZObunvt5I4iCubZA1EQ1BaiYhTAnuL%2B%2Fz6SzLy3YLg9NqHVGkzljSctn91KA85o6F7pWLkw%3D%3D"
                //호출자 환경정보
                + "&MobileApp=User-Agent&MobileOS=ETC"
                //요청 contentId
                + "&contentId=" + 126508
                //기본정보 조회
                + "&defaultYN=Y"
                //주소정보 조회
                + "&addrinfoYN=Y"
                //개요 조회
                + "&overviewYN=Y"
                //json 타입
                + "&_type=json";


        // HTTP GET 요청 보내기
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(apiUrl1, Map.class);

        // 응답 값
        Map<String, Object> responseData = responseEntity.getBody();

        System.out.println("GET Response: " + responseData);
        return responseData;
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
