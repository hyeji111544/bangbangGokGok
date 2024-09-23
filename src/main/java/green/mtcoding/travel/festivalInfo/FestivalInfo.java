package green.mtcoding.travel.festivalInfo;


import com.fasterxml.jackson.annotation.JsonAlias;
import green.mtcoding.travel.review.Review;
import jakarta.persistence.*;
import lombok.Builder;
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
    private String contentTypeId;
    private String sponsor1;
    @JsonAlias("sponsor1tel")
    private String sponsor1Tel;
    private String sponsor2;
    @JsonAlias("sponsor2tel")
    private String sponsor2Tel;
    @JsonAlias("eventenddate")
    private String eventEndDate;
    @JsonAlias("playtime")
    private String playTime;
    @JsonAlias("eventplace")
    private String eventPlace;
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
    // 추가
    private String title;
    private String addr1;
    private String addr2;
    @JsonAlias("firstimage")
    private String firstImage;
    @JsonAlias("firstimage2")
    private String firstImage2;
    @JsonAlias("homepage")
    private String homePage;
    @Lob
    @JsonAlias("infotext")
    private String infoText;
    @JsonAlias("mapx")
    private String mapX;
    @JsonAlias("mapy")
    private String mapY;
    @Lob
    private String overview;
    @JsonAlias("smallimage")
    private String smallImage;
    private String tel;
    @JsonAlias("telname")
    private String telName;
    @JsonAlias("zipcode")
    private String zipCode;

    @Builder
    public FestivalInfo(String contentId, String sponsor1, String sponsor1Tel, String sponsor2, String sponsor2Tel, String eventEndDate, String playTime, String eventPlace, String eventHomePage, String ageLimit, String bookingPlace, String placeInfo, String subEvent, String program, String eventStartDate, String useTimeFestival, String discountInfoFestival, String spendTimeFestival, String festivalGrade, String serialNum, String infoName, String fldgubun, String originImgUrl, String imgName, String smallImageUrl, String cpyrhtDivCd, String viewCount, String likeCount, String title, String addr1, String addr2, String firstImage, String firstImage2, String homePage, String infoText, String mapX, String mapY, String overview, String smallImage, String tel, String telName, String zipCode) {
        this.contentId = contentId;
        this.sponsor1 = sponsor1;
        this.sponsor1Tel = sponsor1Tel;
        this.sponsor2 = sponsor2;
        this.sponsor2Tel = sponsor2Tel;
        this.eventEndDate = eventEndDate;
        this.playTime = playTime;
        this.eventPlace = eventPlace;
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
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.homePage = homePage;
        this.infoText = infoText;
        this.mapX = mapX;
        this.mapY = mapY;
        this.overview = overview;
        this.smallImage = smallImage;
        this.tel = tel;
        this.telName = telName;
        this.zipCode = zipCode;
    }

    @Builder(builderMethodName = "festivalBuilder")
    public FestivalInfo(String contentId, String contentTypeId, String sponsor1, String sponsor1Tel, String sponsor2, String sponsor2Tel, String eventEndDate, String playTime, String eventPlace, String eventStartDate, String useTimeFestival, String infoName, String originImgUrl, String imgName, String smallImageUrl, String title, String addr1, String addr2, String firstImage, String firstImage2, String homePage, String infoText, String mapX, String mapY, String overview, String smallImage, String tel, String telName, String zipCode) {
        this.contentId = contentId;
        this.contentTypeId = contentTypeId;
        this.sponsor1 = sponsor1;
        this.sponsor1Tel = sponsor1Tel;
        this.sponsor2 = sponsor2;
        this.sponsor2Tel = sponsor2Tel;
        this.eventEndDate = eventEndDate;
        this.playTime = playTime;
        this.eventPlace = eventPlace;
        this.eventStartDate = eventStartDate;
        this.useTimeFestival = useTimeFestival;
        this.infoName = infoName;
        this.originImgUrl = originImgUrl;
        this.imgName = imgName;
        this.smallImageUrl = smallImageUrl;
        this.title = title;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.firstImage = firstImage;
        this.firstImage2 = firstImage2;
        this.homePage = homePage;
        this.infoText = infoText;
        this.mapX = mapX;
        this.mapY = mapY;
        this.overview = overview;
        this.smallImage = smallImage;
        this.tel = tel;
        this.telName = telName;
        this.zipCode = zipCode;
    }
}
