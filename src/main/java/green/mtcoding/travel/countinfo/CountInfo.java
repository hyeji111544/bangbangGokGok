package green.mtcoding.travel.countinfo;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="count_info_tb")
public class CountInfo {

    @Id
    @JsonAlias("contentid")
    private String contentId;
    private String viewCount;
    private String likeCount;


}
