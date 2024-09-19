package green.mtcoding.travel.content;


import green.mtcoding.travel.area.Area;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class ContentResponse {

    @Data
    public static class infoListDTO{
        private long count;
        private List<ContentDTO> contents = new ArrayList<>();
        private List<AreaDTO> areas = new ArrayList<>();

        public infoListDTO(List<Content> contentList, long count, List<Area> areaList) {
            this.count = count;
            for (Content content : contentList) {
                this.contents.add(new ContentDTO(content));
            }
            for(Area area : areaList) {
                this.areas.add(new AreaDTO(area));
            }
        }

        @Data
        public static class AreaDTO{
            private String code;
            private String name;

            public AreaDTO(Area area) {
                this.code = area.getCode();
                this.name = area.getName();
            }
        }

        @Data
        public static class ContentDTO {
            private String title;
            private String contentId;
            private String addr1;
            private String areaCode;
            private String contentTypeId;
            private String firstImage;

            // Content 엔티티를 DTO로 변환
            public ContentDTO(Content content) {
                this.title = content.getTitle();
                this.contentId = content.getContentId();
                this.addr1 = content.getAddr1();
                this.areaCode = content.getAreaCode();
                this.contentTypeId = content.getContentTypeId();
                this.firstImage = content.getFirstImage();
                if(this.firstImage == ""){
                    this.firstImage="/images/noimg.jpg";
                }
            }
        }
    }


    /*           hotPlace-start             */
    @Data
    public static class HotPlaceDTO {

        public String contentId;
        public String contentTypeId;

        public String title;
        public String addr1;
        public String firstImage;
        public String viewCount;
        public String likeCount;

        public HotPlaceDTO(Content content) {
            this.contentId = content.getContentId();
            this.contentTypeId = content.getContentTypeId();
            this.title = content.getTitle();
            this.addr1 = content.getAddr1();
            this.firstImage = content.getFirstImage();
            if(firstImage == "") {
                this.firstImage = "/images/hotplace/no-image.jpg";
            }
            this.viewCount = content.getViewCount();
            this.likeCount = content.getLikeCount();
        }
    }
    /*           hotPlace-end             */

}
