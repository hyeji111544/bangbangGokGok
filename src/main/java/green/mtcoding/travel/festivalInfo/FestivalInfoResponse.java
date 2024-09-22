package green.mtcoding.travel.festivalInfo;

import lombok.Data;

public class FestivalInfoResponse {

    // 임시
    @Data
    public static class FestivalDetailDTO  {
        private String contentId;
        private String title;
        private String eventStartDate;
        private String eventEndDate;
        private String eventPlace;
        private String sponsor1;
        private String sponsor1Tel;
        private String sponsor2;
        private String sponsor2Tel;
        private String zipCode;
        private String addr1;
        private String addr2;
        private String firstImage;
        private String firstImage2;
        private String homePage;
        private String imgName;
        private String infoName; // <행사소개>
        private String overview; // 개요
        private String infoText; // 행사내용
        private String mapX;
        private String mapY;
        private String playTime; // 행사시간
        private String tel;
        private String telName;
        private String useTimeFestival; // 요금
        private String smallImage;
        private String originImgUrl;
        private String smallImageUrl;

        public FestivalDetailDTO(FestivalInfo festivalInfo) {
            this.contentId = festivalInfo.getContentId();
            this.title = festivalInfo.getTitle();
            this.eventStartDate = festivalInfo.getEventStartDate();
            this.eventEndDate = festivalInfo.getEventEndDate();
            this.eventPlace = festivalInfo.getEventPlace();
            this.sponsor1 = festivalInfo.getSponsor1();
            this.sponsor1Tel = festivalInfo.getSponsor1Tel();
            this.sponsor2 = festivalInfo.getSponsor2();
            this.sponsor2Tel = festivalInfo.getSponsor2Tel();
            this.zipCode = festivalInfo.getZipCode();
            this.addr1 = festivalInfo.getAddr1();
            this.addr2 = festivalInfo.getAddr2();
            this.firstImage = festivalInfo.getFirstImage();
            this.firstImage2 = festivalInfo.getFirstImage2();
            this.homePage = festivalInfo.getHomePage();
            this.imgName = festivalInfo.getImgName();
            this.infoName = festivalInfo.getInfoName();
            this.overview = festivalInfo.getOverview();
            this.infoText = festivalInfo.getInfoText();
            this.mapX = festivalInfo.getMapX();
            this.mapY = festivalInfo.getMapY();
            this.playTime = festivalInfo.getPlayTime();
            this.tel = festivalInfo.getTel();
            this.telName = festivalInfo.getTelName();
            this.useTimeFestival = festivalInfo.getUseTimeFestival();
            this.smallImage = festivalInfo.getSmallImage();
            this.originImgUrl = festivalInfo.getOriginImgUrl();
            this.smallImageUrl = festivalInfo.getSmallImageUrl();
        }

//        public FestivalDetailDTO(FestivalInfo festivalInfo) {
//            this.contentId = festivalInfo.getContentId();
//            this.contentTypeId = festivalInfo.getContentTypeId();
//            this.eventStartDate = festivalInfo.getEventStartDate();
//            this.eventEndDate = festivalInfo.getEventEndDate();
//            this.eventPlace = festivalInfo.getEventPlace();
//            this.originImgUrl = festivalInfo.getOriginImgUrl();
//            this.title = festivalInfo.getTitle();
//        }
    }

    @Data
    public static class FestivalMainDTO {
        private String contentId;
        private String contentTypeId;
        private String eventStartDate;
        private String eventEndDate;
        private String eventPlace;
        private String originImgUrl;
        private String title;
        private boolean active;
        private int index;

        public FestivalMainDTO(String contentId, String contentTypeId, String eventStartDate, String eventEndDate, String eventPlace, String originImgUrl, String title) {
            this.contentId = contentId;
            this.contentTypeId = contentTypeId;
            this.eventStartDate = eventStartDate;
            this.eventEndDate = eventEndDate;
            this.eventPlace = eventPlace;
            this.originImgUrl = originImgUrl;
            this.title = title;
        }

        public FestivalMainDTO(String contentId, String contentTypeId, String eventStartDate, String eventEndDate, String eventPlace, String originImgUrl, String title, boolean active, int index) {
            this.contentId = contentId;
            this.contentTypeId = contentTypeId;
            this.eventStartDate = eventStartDate;
            this.eventEndDate = eventEndDate;
            this.eventPlace = eventPlace;
            this.originImgUrl = originImgUrl;
            this.title = title;
            this.active = active;
            this.index = index;
        }
    }
}