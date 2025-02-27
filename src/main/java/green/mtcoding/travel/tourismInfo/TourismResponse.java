package green.mtcoding.travel.tourismInfo;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class TourismResponse {


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class OpenApiDto {
        private String contentId;
        private CommonDTO common;
        private IntroDTO intro;
        private List<InfoDTO> infos;
        private List<ImgDTO> imgs;

        public OpenApiDto(String contentId ,List<InfoDTO> infos, CommonDTO common, IntroDTO intro, List<ImgDTO> imgs) {
            this.contentId = contentId;
            this.infos = infos;
            this.common = common;
            this.intro = intro;
            this.imgs = imgs;
        }



    }


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class CommonDTO{
        // 가리왕산
        private String title;
        @JsonAlias("homepage")
        private String homePage;
        @JsonAlias("firstimage")
        private String firstImage;
        private String addr1;
        @JsonAlias("mapx")
        private String mapX;
        @JsonAlias("mapy")
        private String mapY;
        private String overview;

        public void setDefaultImage() {
            if (this.firstImage == null || this.firstImage.equals("")) {
                this.firstImage = "/images/noimg.jpg";
            }
        }

//        public CommonDTO(TourismInfo tourismInfo){
//            this.title = tourismInfo.getTitle();
//            this.homePage = tourismInfo.getHomePage();
//            this.firstImage = tourismInfo.getFirstImage();
//            this.firstImage2 = tourismInfo.getFirstImage2();
//            this.addr1 = tourismInfo.getAddr1();
//            this.mapX = tourismInfo.getMapX();
//            this.mapY = tourismInfo.getMapY();
//            this.overview = tourismInfo.getOverview();
//        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class InfoDTO{
        //리스트로 반복됨 "inforname" : "infotext" 이렇게
        @JsonAlias("infoname")
        private String infoName; // 키
        @JsonAlias("infotext")
        private String infoText; // 값
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class ImgDTO{
        //리스트로 반복됨 "inforname" : "infotext" 이렇게
        @JsonAlias("originimgurl")
        private String infoName; // 키
        @JsonAlias("smallimageurl")
        private String smallImageUrl;
        @JsonAlias("imgname")
        private String imgName; // 값

               /* 이거 이미지 인데 어카지
        http://apis.data.go.kr/B551011/KorService1/detailImage1?ServiceKey=인증키&contentId=127508&MobileOS=ETC&MobileApp=AppTest&imageYN=Y&subImageYN=Y&numOfRows=10
            <item>
            <contentid>127508</contentid>
            <originimgurl>http://tong.visitkorea.or.kr/cms/resource/57/2987657_image2_1.png</originimgurl>
            <imgname>관광두레 5월기사 강원정선 곤디 14</imgname>
            <smallimageurl>http://tong.visitkorea.or.kr/cms/resource/57/2987657_image3_1.png</smallimageurl>
            <cpyrhtDivCd>Type1</cpyrhtDivCd>
            <serialnum>2987657_3</serialnum>
            </item>
         */
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public static class IntroDTO{
        @JsonAlias("infocenter")
        private String infoCenter;  // 문의 및 안내
        @JsonAlias("restdate")
        private String restDate;    // 쉬는 날
        @JsonAlias("expagerange")
        private String expAgeRange; // 체험가능 연령
        @JsonAlias("useseason")
        private String useSeason;
        @JsonAlias("usetime")
        private String useTime;     // 이용시간
        private String parking;     // 주차시설
        @JsonAlias("chkbabycarriage")
        private String chkBabyCarriage; // 유모차 대여 여부
        @JsonAlias("chkpet")
        private String chkPet;      // 애완동물 동반가능여부
        @JsonAlias("chkcreditcard")
        private String chkCreditCard;   // 신용카드 가능 여부

        public void setDefaults() {
            if (this.infoCenter == null || this.infoCenter.isEmpty()) {
                this.infoCenter = null;
            }
            if (this.restDate == null || this.restDate.isEmpty()) {
                this.restDate = null;
            }
            if (this.expAgeRange == null || this.expAgeRange.isEmpty()) {
                this.expAgeRange = null;
            }
            if (this.useSeason == null || this.useSeason.isEmpty()) {
                this.useSeason = null;
            }
            if (this.useTime == null || this.useTime.isEmpty()) {
                this.useTime = null;
            }
            if (this.parking == null || this.parking.isEmpty()) {
                this.parking = null;
            }
            if (this.chkBabyCarriage == null || this.chkBabyCarriage.isEmpty()) {
                this.chkBabyCarriage = null;
            }
            if (this.chkPet == null || this.chkPet.isEmpty()) {
                this.chkPet = null;
            }
            if (this.chkCreditCard == null || this.chkCreditCard.isEmpty()) {
                this.chkCreditCard = null;
            }
        }

    }
}
