package green.mtcoding.travel.content;


import green.mtcoding.travel.area.Area;
import lombok.Data;
import org.springframework.data.domain.Page;

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
    public static class HotPlacePageDTO {
        private Integer number; //현재 페이지
        private Integer totalPage; // 전체페이지 개수
        private Integer size; // 한 페이지의 아이템 개수
        private boolean first;
        private boolean last;
        private Integer prev; //현재 페이지 -1
        private Integer next; //현재 페이지 +1

        private boolean ajax;

        private List<Integer> numbers = new ArrayList<>();
        private List<HotPlaceDTO> contents = new ArrayList<>(); //일단 빈 객체를 만들어서 초기화 해둔다.

        public HotPlacePageDTO(List<Content> contents, int perPage, int page, Long totalCount) {

            this.number = page;
            //Repository에 maxResult값으로 사용하는 perPage를 가져 왔다.
            //size가 페이지 숫자 크기 묶음 사이즈이다. 10페이지씩 만들기 위해서 20사이즈인 perPage의 절반으로
            this.size = perPage/2;


            if(totalCount % perPage == 0 ) {
                this.totalPage = (int) (totalCount / perPage);
            } else if(totalCount % perPage != 0) {
                this.totalPage = (int) (totalCount / perPage + 1);
            }

            System.out.println("page = " + number);
            System.out.println("perPage = " + size);
            System.out.println("totalCount = " + totalCount);
            System.out.println("totalPage = " + totalPage);

            if (number == 0) {
                this.prev = 0;
                this.first = true;
            } else {
                this.prev = number - 1;
            }
            if(number == totalPage -1) {//인덱스는 0부터시작이고 토탈은 1부터 시작이므로 토탈-1이 인덱스 마지막
                this.next = totalPage -1;
                this.last = true;
            } else {
                this.next = number + 1;
            }

            int temp = (number / size)*size;
            for(int i=temp; i<temp+size;i++){
                if(i > totalPage) {
                    break;
                }

                this.numbers.add(i);
            }

            for(Content content: contents) {
                this.contents.add(new HotPlaceDTO(content));
            }
        }


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



    }



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
