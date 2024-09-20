package green.mtcoding.travel.festivalInfo;


import com.fasterxml.jackson.annotation.JsonAlias;
import green.mtcoding.travel.review.Review;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
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
    private String title;

    public FestivalInfo(String contentId, String contenttypeid, String sponsor1, String sponsor1Tel, String sponsor2, String sponsor2Tel, String eventenddate, String playTime, String eventplace, String eventHomePage, String ageLimit, String bookingPlace, String placeInfo, String subEvent, String program, String eventStartDate, String useTimeFestival, String discountInfoFestival, String spendTimeFestival, String festivalGrade, String serialNum, String infoName, String fldgubun, String originImgUrl, String imgName, String smallImageUrl, String cpyrhtDivCd, String viewCount, String likeCount, String title) {
        this.contentId = contentId;
        this.contenttypeid = contenttypeid;
        this.sponsor1 = sponsor1;
        this.sponsor1Tel = sponsor1Tel;
        this.sponsor2 = sponsor2;
        this.sponsor2Tel = sponsor2Tel;
        this.eventenddate = eventenddate;
        this.playTime = playTime;
        this.eventplace = eventplace;
        this.eventHomePage = eventHomePage;
        this.ageLimit = ageLimit;
        this.bookingPlace = bookingPlace;
        this.placeInfo = placeInfo;
        this.subEvent = subEvent;
        this.program = program;
        this.eventStartDate = eventStartDate;
        this.useTimeFestival = useTimeFestival;
        this.discountInfoFestival = discountInfoFestival;
        this.spendTimeFestival = spendTimeFestival;
        this.festivalGrade = festivalGrade;
        this.serialNum = serialNum;
        this.infoName = infoName;
        this.fldgubun = fldgubun;
        this.originImgUrl = originImgUrl;
        this.imgName = imgName;
        this.smallImageUrl = smallImageUrl;
        this.cpyrhtDivCd = cpyrhtDivCd;
        this.viewCount = viewCount;
        this.likeCount = likeCount;
        this.title = title;
    }
}
