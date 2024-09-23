package green.mtcoding.travel.tourismInfo;


import com.fasterxml.jackson.annotation.JsonAlias;
import green.mtcoding.travel.review.Review;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="tourisminfo_tb")
public class TourismInfo {

    @Id
    @JsonAlias("contendid")
    private String contentId;

    @OneToMany(mappedBy = "tourismInfo", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonAlias("serialnum")
    private String serialNum;

    private String title;
    @JsonAlias("createdtime")
    private String createdTime;
    @JsonAlias("modifiedtime")
    private String modifiedTime;
    @JsonAlias("homepage")
    private String homePage;
    @JsonAlias("firstimage")
    private String firstImage;
    @JsonAlias("firstimage2")
    private String firstImage2;
    private String addr1;
    @JsonAlias("mapx")
    private String mapX;
    @JsonAlias("mapy")
    private String mapY;
    private String overview;


    /*  img */
    @JsonAlias("originimgurl")
    private String originImgUrl;
    @JsonAlias("imgname")
    private String imgname;
    @JsonAlias("smallimageurl")
    private String smallImageUrl;
    private String cpyrhtDivCd;

    /*  Intro   */
    @JsonAlias("infocenter")
    private String infoCenter;
    @JsonAlias("opendate")
    private String openDate;
    @JsonAlias("restdate")
    private String restDate;
    @JsonAlias("expguide")
    private String expGuide;
    @JsonAlias("expagerange")
    private String expAgeRange;
    @JsonAlias("accomcount")
    private String accomCount;
    @JsonAlias("useseason")
    private String useSeason;
    @JsonAlias("usetime")
    private String useTime;
    private String parking;
    @JsonAlias("chkbabycarriage")
    private String chkBabyCarriage;
    @JsonAlias("chkpet")
    private String chkPet;
    @JsonAlias("chkcreditcard")
    private String chkCreditCard;

    /*  Info    */
    @JsonAlias("infoname")
    private String infoName;
    @JsonAlias("infotext")
    private String infoText;

    private String viewCount;
    private String likeCount;

}
