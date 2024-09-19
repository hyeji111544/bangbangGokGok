package green.mtcoding.travel.restourantInfo;


import com.fasterxml.jackson.annotation.JsonAlias;
import green.mtcoding.travel.review.Review;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="restaurantinfo_tb")
public class RestaurantInfo {

    @Id
    @JsonAlias("contendid")
    private String contentid;

    @OneToMany(mappedBy = "restaurantInfo", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @JsonAlias("contenttypeid")
    private String contentTypeId;
    private String title;
    @JsonAlias("createdtime")
    private String createdTime;
    @JsonAlias("modifiedtime")
    private String modifiedTime;
    private String tel;
    @JsonAlias("temlname")
    private String telName;
    @JsonAlias("homepage")
    private String homePage;
    @JsonAlias("booktour")
    private String bookTour;
    @JsonAlias("firstimage")
    private String firstImage;
    @JsonAlias("firstimage2")
    private String firstImage2;
    private String cpyrhtDivCd;
    @JsonAlias("areacode")
    private String areaCode;
    @JsonAlias("sigungucode")
    private String sigunguCode;
    private String cat1;
    private String cat2;
    private String cat3;
    private String addr1;
    private String addr2;
    @JsonAlias("zipcode")
    private String zipCode;
    @JsonAlias("mapx")
    private String mapX;
    @JsonAlias("mapy")
    private String mapY;
    @JsonAlias("mlevel")
    private String mLevel;
    @JsonAlias("overview")
    private String overView;
    private String seat;
    @JsonAlias("kidsfacility")
    private String kidsFacility;
    @JsonAlias("firstmenu")
    private String firstMenu;
    @JsonAlias("treatmenu")
    private String treatMenu;
    private String smoking;
    private String packing;
    @JsonAlias("infocenterfood")
    private String infoCenterFood;
    @JsonAlias("scalefood")
    private String scaleFood;
    @JsonAlias("parkingfood")
    private String parkingFood;
    @JsonAlias("opendatefood")
    private String openDateFood;
    @JsonAlias("opentimefood")
    private String openTimeFood;
    @JsonAlias("restdatefood")
    private String restDateFood;
    @JsonAlias("discountinfofood")
    private String discountInfoFood;
    @JsonAlias("chkcreditcardfood")
    private String chkCreditCardFood;
    @JsonAlias("reservationfood")
    private String reservationFood;
    @JsonAlias("lcnsno")
    private String lcnsNo;
    @JsonAlias("originimgurl")
    private String originImgUrl;
    @JsonAlias("imagname")
    private String imgName;
    @JsonAlias("smallimageurl")
    private String smallImageUrl;
    @JsonAlias("serialnum")
    private String serialNum;
    private String viewCount;
    private String likeCount;


}
