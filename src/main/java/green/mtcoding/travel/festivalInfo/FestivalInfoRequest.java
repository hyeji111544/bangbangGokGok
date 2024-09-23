package green.mtcoding.travel.festivalInfo;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Id;
import lombok.Data;

public class FestivalInfoRequest {

    @Data
    public static class SaveDTO {

        @JsonAlias("contentid")
        private String contentId;
        private String title;
        private String sponsor1;
        @JsonAlias("sponsor1tel")
        private String sponsor1Tel;
        private String sponsor2;
        @JsonAlias("sponsor2tel")
        private String sponsor2Tel;
        @JsonAlias("eventenddate")
        private String eventEndDate;
        @JsonAlias("eventstartdate")
        private String eventStartDate;
        // 추가

        private String addr1;
        private String addr2;
        @JsonAlias("eventplace")
        private String eventPlace;
        @JsonAlias("firstimage")
        private String firstImage;
        @JsonAlias("firstimage2")
        private String firstImage2;
        @JsonAlias("homepage")
        private String homePage;
        @JsonAlias("imgname")
        private String imgName;
        @JsonAlias("infoname")
        private String infoName;
        @JsonAlias("infotext")
        private String infoText;
        @JsonAlias("mapx")
        private String mapX;
        @JsonAlias("mapy")
        private String mapY;
        @JsonAlias("originimgurl")
        private String originImgUrl;
        private String overview;
        @JsonAlias("playtime")
        private String playTime;
        @JsonAlias("smallimage")
        private String smallImage;
        private String tel;
        @JsonAlias("telname")
        private String telName;
        @JsonAlias("usetimefestival")
        private String useTimeFestival;
        @JsonAlias("zipcode")
        private String zipCode;
        @JsonAlias("smallimageurl")
        private String smallImageUrl;


        public FestivalInfo toEntity() { // insert 할때만 필요
            return FestivalInfo.festivalBuilder()
                    .contentId(contentId)
                    .sponsor1(sponsor1)
                    .sponsor1Tel(sponsor1Tel)
                    .sponsor2(sponsor2)
                    .sponsor2Tel(sponsor2Tel)
                    .eventEndDate(eventEndDate)
                    .playTime(playTime)
                    .eventPlace(eventPlace)
                    .eventStartDate(eventStartDate)
                    .useTimeFestival(useTimeFestival)
                    .infoName(infoName)
                    .originImgUrl(originImgUrl)
                    .imgName(imgName)
                    .smallImageUrl(smallImageUrl)
                    .title(title)
                    .addr1(addr1)
                    .addr2(addr2)
                    .firstImage(firstImage)
                    .firstImage2(firstImage2)
                    .homePage(homePage)
                    .infoText(infoText)
                    .mapX(mapX)
                    .mapY(mapY)
                    .overview(overview)
                    .smallImage(smallImage)
                    .tel(tel)
                    .telName(telName)
                    .zipCode(zipCode)
                    .build();
        }

    }
}
