package green.mtcoding.travel.content;

import lombok.Data;

import java.util.List;

public class ContentRequest {

    @Data
    public static class InfoRequestDTO {
        private final String contentTypeId= "12";
        private String area ="";
        private String sigungu ="";
        private String sortBy ="";
        private int page= 0;
    }

    /*           hotPlace-start             */
    @Data
    public static class HotplaceDTO {
        private String category="touristAttractions";
        private String area;
        private List<String> sigungu;
        private int page=1;
        private String keyword="";
    }
    /*           hotPlace-end             */




}
