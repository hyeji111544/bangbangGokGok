package green.mtcoding.travel.tourismInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import green.mtcoding.travel.content.Content;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Service
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
    public void getRequest() throws JsonProcessingException, URISyntaxException {
        // 요청을 보낼 URL
        String url = "https://apis.data.go.kr/B551011/KorService1/detailCommon1"
                //호출자 OS 구분 : IOS (아이폰), AND (안드로이드), WIN (윈도우폰), ETC(기타)
                + "?MobileOS=ETC"
                //호출자 어플이름(마음대로)
                + "&MobileApp=bangbang-gokgok"
                //응답메세지 형식 : REST방식의 URL호출 시 json값 추가(디폴트 응답메세지 형식은XML)
                + "&_type=json"
                //요청 contentId
                + "&contentId=" + "126508"
                //요청 contentTypeId (12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점)
                + "&contentTypeId=" + "12"

                //기본정보 조회 ( Y,N )
                + "&defaultYN=Y"
                //원본, 썸네일대표 이미지, 이미지 공공누리유형정보 조회여부( Y,N )
                + "&firstImageYN=Y"
                //지역코드, 시군구코드조회여부( Y,N )
                + "&areacodeYN=Y"
                //대,중,소분류코드조회여부( Y,N )
                + "&catcodeYN=Y"
                //주소정보 조회
                + "&addrinfoYN=Y"
                //좌표정보 조회 X, Y 조회여부( Y,N )
                + "&mapinfoYN=Y"
                //콘텐츠 개요 조회
                + "&overviewYN=Y"
                //한 페이지 결과수
                + "&numOfRows=1"
                //페이지 번호
                + "&pageNo=1"

                //인증키
                + "&serviceKey=" + "guF8R5Fvce%2B4pE1ZObunvt5I4iCubZA1EQ1BaiYhTAnuL%2B%2Fz6SzLy3YLg9NqHVGkzljSctn91KA85o6F7pWLkw%3D%3D";



        //특수문자가 포함된 인증키같은 것을 전달할 때 주소를 URI클래스에 감싸서 그대로 전달
        URI apiUri = new URI(url);

        // HTTP GET 요청 보내기
        ResponseEntity<Map> response = restTemplate.getForEntity(apiUri, Map.class);
        Map<String, Object> jsonResponse = response.getBody();
        System.out.println("jsonResponse = " + jsonResponse);

        Map<String, Object> bodyMap = (Map<String, Object>) jsonResponse.get("response");
        Map<String, Object> bodyContent = (Map<String, Object>) bodyMap.get("body");
        Map<String, Object> items = (Map<String, Object>) bodyContent.get("items");
        List<Map<String, Object>> item = (List<Map<String, Object>>) items.get("item");

        System.out.println("item = " + item);

        System.out.println("content = " + item.get(0));

        String json = objectMapper.writeValueAsString(item.get(0));
        System.out.println("json = " + json);
        TourismInfo tourismInfo = objectMapper.convertValue(item.get(0), TourismInfo.class);

        System.out.println("tourismInfo = " + tourismInfo);

/*
        Map<String, Object> responseMap = objectMapper.readValue(jsonResponse, Map.class);

    // "items" 아래에 있는 "item" 배열만 추출
        Map<String, Object> bodyMap = (Map<String, Object>) responseMap.get("response");
        Map<String, Object> bodyContent = (Map<String, Object>) bodyMap.get("body");
        Map<String, Object> items = (Map<String, Object>) bodyContent.get("items");
        Object itemList = items.get("item");
*/





        // 응답 값
        //Map<String, Object> responseData = objectMapper.readValue(jsonResponse, Map.class);

        //System.out.println("responseData = " + responseMap);


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
