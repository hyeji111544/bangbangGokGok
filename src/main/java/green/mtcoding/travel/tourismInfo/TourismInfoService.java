package green.mtcoding.travel.tourismInfo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import green.mtcoding.travel.global.error.ex.ExceptionApi404;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TourismInfoService {

    private final TourismInfoRepository tourismInfoRepository;
    private String serviceKey = "guF8R5Fvce%2B4pE1ZObunvt5I4iCubZA1EQ1BaiYhTAnuL%2B%2Fz6SzLy3YLg9NqHVGkzljSctn91KA85o6F7pWLkw%3D%3D";


    /*           info-start             */

    public TourismResponse.OpenApiDto getDetailContent(String contentId) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException {
        List<TourismResponse.InfoDTO> infos = getDetailInfo(contentId);
        TourismResponse.IntroDTO detailIntro = getDetailIntro(contentId);
        TourismResponse.CommonDTO detailCommon = getDetailCommon(contentId);
        List<TourismResponse.ImgDTO> imgs =getDetailImg(contentId);

        return new TourismResponse.OpenApiDto(contentId, infos, detailCommon, detailIntro, imgs);
    }


    public List<TourismResponse.InfoDTO> getDetailInfo(String contentId) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException {
        String url = "http://apis.data.go.kr/B551011/KorService1/detailInfo1"
                + "?ServiceKey=" + serviceKey
                + "&contentTypeId=12"
                + "&contentId=" + contentId
                + "&MobileOS=ETC"
                + "&MobileApp=AppTest"
                + "&_type=json";

        URI apiUri = new URI(url);
        JsonNode responseJs = fetch(apiUri);

        ObjectMapper objectMapper = new ObjectMapper();
        List<TourismResponse.InfoDTO> infoList = new ArrayList<>();

        for(JsonNode jsonNode : responseJs) {
            TourismResponse.InfoDTO infoDTO = objectMapper.treeToValue(jsonNode, TourismResponse.InfoDTO.class);
            infoList.add(infoDTO);
        }
        return infoList;
    }

    public List<TourismResponse.ImgDTO> getDetailImg(String contentId) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException {
        String url = "http://apis.data.go.kr/B551011/KorService1/detailImage1"
                + "?ServiceKey=" + serviceKey
                + "&contentId=" + contentId
                + "&MobileOS=ETC"
                + "&imageYN=Y"
                + "&subImageYN=Y"
                + "&MobileApp=AppTest"
                + "&_type=json";

        URI apiUri = new URI(url);
        JsonNode responseJs = fetch(apiUri);
        if(responseJs.size()<0) {
            throw new ExceptionApi404("요청된 사진이 없습니다.");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        List<TourismResponse.ImgDTO> imgList = new ArrayList<>();

        for(JsonNode jsonNode : responseJs) {
            TourismResponse.ImgDTO imgDTO = objectMapper.treeToValue(jsonNode, TourismResponse.ImgDTO.class);
            imgList.add(imgDTO);
        }

        return imgList;

    }

    public TourismResponse.IntroDTO getDetailIntro(String contentId) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException {
        String url = "http://apis.data.go.kr/B551011/KorService1/detailIntro1"
                + "?ServiceKey=" + serviceKey
                + "&contentTypeId=12"
                + "&contentId=" + contentId
                + "&MobileOS=ETC"
                + "&MobileApp=AppTest"
                + "&_type=json";

        URI apiUri = new URI(url);
        JsonNode response= fetch(apiUri);

       // System.out.println(response.get(0).toString());

        String jsonData = response.get(0).toString();
        ObjectMapper objectMapper = new ObjectMapper();
        TourismResponse.IntroDTO dto = objectMapper.readValue(jsonData, TourismResponse.IntroDTO.class);
        dto.setDefaults();
        //System.out.println("toString : ");
        //System.out.println(dto);

        return dto;
    }

    public TourismResponse.CommonDTO getDetailCommon(String contentId) throws UnsupportedEncodingException, URISyntaxException, JsonProcessingException {
        String url = "http://apis.data.go.kr/B551011/KorService1/detailCommon1"
                + "?ServiceKey=" + serviceKey
                + "&contentTypeId=12"
                + "&contentId=" + contentId
                + "&MobileOS=ETC"
                + "&MobileApp=AppTest"
                + "&defaultYN=Y"
                + "&firstImageYN=Y"
                + "&areacodeYN=Y"
                + "&catcodeYN=Y"
                + "&addrinfoYN=Y"
                + "&mapinfoYN=Y"
                + "&overviewYN=Y"
                + "&_type=json";

        URI apiUri = new URI(url);
        JsonNode response = fetch(apiUri);

        //System.out.println(response.get(0).toString());

        String jsonData = response.get(0).toString();
        ObjectMapper objectMapper = new ObjectMapper();
        TourismResponse.CommonDTO dto = objectMapper.readValue(jsonData, TourismResponse.CommonDTO.class);
        System.out.println(dto.getFirstImage());
        dto.setDefaultImage();
        //System.out.println("toString : ");
        //System.out.println(dto);

        return dto;
    }

    public JsonNode fetch(URI url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String jsonString = restTemplate.getForObject(url, String.class);

            // Jackson ObjectMapper를 사용하여 JSON 파싱
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode root = objectMapper.readTree(jsonString);

            // 필요한 item만 추출
            JsonNode itemsNode = root.path("response").path("body").path("items").path("item");


            return itemsNode;
        } catch (Exception e) {
          throw new ExceptionApi404(e.getMessage());
        }
    }


    /*           info-end             */


}
