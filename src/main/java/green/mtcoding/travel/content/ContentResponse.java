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
            if (areaList != null) {
                for (Area area : areaList) {
                    this.areas.add(new AreaDTO(area));
                }
            }
        }

        @Data
        public static class AreaDTO{
            private String code;
            private String name;

            public AreaDTO(Area area) {
                this.code = area.getCode();
                this.name = area.getName() != null && area.getName().length() > 2 ?
                        area.getName().substring(0, 2) :
                        area.getName();
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
        private Long itemCount; //현재 페이지 아이템 개수
        private Long totalCount;  //총 아이템 개수
        private Integer size; // 페이지 범위 ( 1~10, 11~20 이런 범위)
        private boolean first;
        private boolean last;
        private Integer prev; //현재 페이지 -1
        private Integer next; //현재 페이지 +1

        private boolean ajax;

        private List<Integer> numbers = new ArrayList<>();
        private List<HotPlaceDTO> contents = new ArrayList<>(); //일단 빈 객체를 만들어서 초기화 해둔다.

        public HotPlacePageDTO(List<Content> contents, int perPage, int page, Long totalCount) {

            this.number = page;
            this.totalCount = totalCount;



            //Repository에 maxResult값으로 사용하는 perPage를 가져 왔다.
            //size가 페이지 숫자 크기 묶음 사이즈이다. 10페이지씩 만들고 싶다. (1~10, 11~20 이런식으로)
            this.size = 10;


            //페이지 시작이 0이라면 1씩 빼야한다. 원리 나머지가 0일때는 계산 그대로. 나머지가 존재하면 계산에서 +1인데 -1씩 해준 상태
            if (totalCount % perPage == 0) {
                this.totalPage = (int) (totalCount / perPage);
            } else if (totalCount % perPage != 0) {
                this.totalPage = (int) (totalCount / perPage) + 1;
            }

            System.out.println("page = " + number);
            System.out.println("perPage = " + size);
            System.out.println("totalCount = " + totalCount);
            System.out.println("totalPage = " + totalPage);

            if (number == 1) {
                this.prev = 1;
                this.first = true;
            } else {
                this.prev = number - 1;
            }
            if (number == totalPage) { //인덱스는 0부터시작이고 페이지는 1부터 시작이므로 토탈-1이 인덱스 마지막인데 지금은 인덱스와 페이지가 일치이므로 인덱스 = 토탈이므로 -1이 아니고 같을 때로
                this.next = totalPage;
                this.last = true;
            } else {
                this.next = number + 1;
            }

            //현재 페이지에 아이템 개수
            if(last) {
                itemCount = ((long) number * perPage) - totalPage;
            }
            itemCount = (long) number * perPage;




            // 현재 페이지 number가 1부터 시작한다고 (size+1) 하면 볼륨이 10개가 아니라 11개가 돼서 다음 페이지 묶음으로 넘어갈 때 11의 배수가 돼야 한다.
            // 페이지 묶음 볼륨을 +1 할 것이 아니라 현재 페이지가 1이므로 시작을 number -1 하면 size 볼륨은 10개로 유지된다.
            int temp = ((number-1) / size) * size;

            for (int i = temp + 1; i < temp + size + 1; i++) {
                if (i > totalPage) {
                    break;
                }

                this.numbers.add(i);

            }

            for (Content content : contents) {
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
                if (firstImage == "") {
                    this.firstImage = "/img/hotplace/no-image.jpg";
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
