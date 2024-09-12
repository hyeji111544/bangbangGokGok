package green.mtcoding.travel.user;

import green.mtcoding.travel.review.Review;
import green.mtcoding.travel.scrap.Scrap;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 20, nullable = false, unique = true)
    private String loginId;  // 회원 ID (유니크)

    @Column(nullable = false)
    private String password;

    @Column(length = 255)
    private String img;

    @Column(nullable = false, unique = true)
    private String nickName;

    private String email;

    @Column(length = 13)
    private String phone;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Review> reviews;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Scrap> scraps;

}
