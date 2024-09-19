package green.mtcoding.travel.scrap;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.user.User;
import jakarta.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="scrap_tb")
public class Scrap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Content content;

    private boolean  isScrap;

}
