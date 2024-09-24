package green.mtcoding.travel.review;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.festivalInfo.FestivalInfo;
import green.mtcoding.travel.tourismInfo.TourismInfo;
import green.mtcoding.travel.user.User;
import green.mtcoding.travel.restourantInfo.RestaurantInfo;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@NoArgsConstructor
@Entity
@Data
@Table(name="review_tb")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String context;

    @CreationTimestamp
    private Timestamp createdAt;

    private double rating;  // 리뷰 별점 (TINYINT에 해당)

    private boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;  // 회원 ID (외래 키로 참조)

    @ManyToOne(fetch = FetchType.LAZY)
    private FestivalInfo festivalInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private TourismInfo tourismInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    private RestaurantInfo restaurantInfo;

    @Builder
    public Review(Integer id, String context, User user, Content content, double rating){
        this.id = id;
        this.context = context;
        this.user = user;
        this.content = content;
        this.rating = rating;
    }

}
