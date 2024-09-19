package green.mtcoding.travel.festivalInfo;


import com.fasterxml.jackson.annotation.JsonAlias;
import green.mtcoding.travel.review.Review;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="festivalinfo_tb")
public class FestivalInfo {

    @Id
    @JsonAlias("contentid")
    private String contentId;

    @OneToMany(mappedBy = "festivalInfo", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonAlias("contenttypeid")
    private String contenttypeid;
    private String sponsor1;
    @JsonAlias("sponsor1tel")
    private String sponsor1Tel;
    private String sponsor2;
    @JsonAlias("sponsor2tel")
    private String sponsor2Tel;
    @JsonAlias("eventenddate")
    private String eventenddate;
    @JsonAlias("playtime")
    private String playTime;
    @JsonAlias("eventplace")
    private String eventplace;
    @JsonAlias("eventhomepage")
    private String eventHomePage;
    @JsonAlias("agelimit")
    private String ageLimit;
    @JsonAlias("bookingplace")
    private String bookingPlace;
    @JsonAlias("placeinfo")
    private String placeInfo;
    @JsonAlias("subevent")
    private String subEvent;
    private String program;
    @JsonAlias("eventstartdate")
    private String eventStartDate;
    @JsonAlias("usetimefestival")
    private String useTimeFestival;
    @JsonAlias("discountinfofestival")
    private String discountInfoFestival;
    @JsonAlias("spendtimefestival")
    private String spendTimeFestival;
    @JsonAlias("festivalgrade")
    private String festivalGrade;
    @JsonAlias("serialnum")
    private String serialNum;
    @JsonAlias("infoname")
    private String infoName;
    private String fldgubun;
    @JsonAlias("originimgurl")
    private String originImgUrl;
    @JsonAlias("imgname")
    private String imgName;
    @JsonAlias("smallimageurl")
    private String smallImageUrl;
    private String cpyrhtDivCd;
    private String viewCount;
    private String likeCount;


}
