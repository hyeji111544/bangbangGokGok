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
    private String contentid;

    @OneToMany(mappedBy = "tourismInfo", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonAlias("serialnum")
    private String serialNum;
    @JsonAlias("infoname")
    private String infoName;
    @JsonAlias("infotext")
    private String infoText;
    private String fldgubun;
    private String heritage1;
    private String heritage2;
    private String heritage3;
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
    @JsonAlias("originimgurl")
    private String originImgUrl;
    @JsonAlias("imgname")
    private String imgname;
    @JsonAlias("smallimageurl")
    private String smallImageUrl;
    private String cpyrhtDivCd;
    private String viewCount;
    private String likeCount;

}
