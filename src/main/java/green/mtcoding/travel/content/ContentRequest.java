package green.mtcoding.travel.content;

import lombok.Data;

public class ContentRequest {

    @Data
    public static class InfoRequestDTO {
        private final String contentTypeId= "12";
        private String area ="";
        private String sigungu ="";
        private String sortBy ="";
        private int page= 0;
    }
}
