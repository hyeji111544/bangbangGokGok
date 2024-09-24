package green.mtcoding.travel.scrap;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.user.UserResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ScrapResponse {

    @Data
    public static class MypageScrapDTO {
        private List<ScrapResponse.MypageUserDTO> userInfo;
        private List<ScrapResponse.ScrapListDTO> scrapList;

        public MypageScrapDTO(List<ScrapListDTO> scrapList, List<MypageUserDTO> userInfo) {
            this.scrapList = scrapList;
            this.userInfo = userInfo;
        }
    }

    @Data
    public static class MypageUserDTO{
        private int id;
        private String nickname;
        private String profile;

        public MypageUserDTO(int id, String nickname, String profile) {
            this.id = id;
            this.nickname = nickname;
            this.profile = profile;
        }
    }

    @Data
    public static class ScrapListDTO {

        private Integer id;
        private boolean isScrap;
        private String contentContentId;
        private String addr1;
        private String contentTypeId;
        private String title;
        private String firstImage;

        public ScrapListDTO(Integer id, boolean isScrap, String contentContentId, String addr1, String contentTypeId, String title, String firstImage) {
            this.id = id;
            this.isScrap = isScrap;
            this.contentContentId = contentContentId;
            this.addr1 = addr1;
            this.contentTypeId = contentTypeId;
            this.title = title;
            this.firstImage = firstImage;
        }
    }

}
