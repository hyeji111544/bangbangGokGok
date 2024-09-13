package green.mtcoding.travel.user;

import green.mtcoding.travel.review.Review;
import green.mtcoding.travel.scrap.Scrap;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name="user_tb")
@NoArgsConstructor
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

    @Builder
    public User(Integer id, String loginId, String password, String img, String nickName, String email, String phone) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.img = img;
        this.nickName = nickName;
        this.email = email;
        this.phone = phone;
    }

}
