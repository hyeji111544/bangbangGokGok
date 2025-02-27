package green.mtcoding.travel.content;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
@Table(name="content_tb")
public class  Content {

    @Id
    @JsonAlias("contendid")
    private String contentId;
    private String addr1;
    private String addr2;
    @JsonAlias("areacode")
    private String areaCode;
    @JsonAlias("booktour")
    private String bookTour;
    private String cat1;
    private String cat2;
    private String cat3;
    @JsonAlias("contenttypeid")
    private String contentTypeId;
    @JsonAlias("createdtime")
    private String createdTime;
    @JsonAlias("firstimage")
    private String firstImage;
    @JsonAlias("firstimage2")
    private String firstImage2;
    private String cpyrhtDivCd;
    @JsonAlias("mapx")
    private String mapX;
    @JsonAlias("mapy")
    private String mapY;
    @JsonAlias("mlevel")
    private String mLevel;
    @JsonAlias("modifiedtime")
    private String modifiedTime;
    @JsonAlias("sigungucode")
    private String sigunguCode;
    private String tel;
    private String title;
    @JsonAlias("zipcode")
    private String zipCode;
    private String viewCount;
    private String likeCount;

    @Builder
    public Content(String contentId, String addr1, String areaCode, String contentTypeId, String firstImage, String sigunguCode, String title) {
        this.contentId = contentId;
        this.addr1 = addr1;
        this.areaCode = areaCode;
        this.contentTypeId = contentTypeId;
        this.firstImage = firstImage;
        this.sigunguCode = sigunguCode;
        this.title = title;
    }

}











