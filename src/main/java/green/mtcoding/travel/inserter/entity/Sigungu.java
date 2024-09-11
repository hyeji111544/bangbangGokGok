package green.mtcoding.travel.inserter.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "sigungu_tb")
public class Sigungu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private String name;




    // 여러 Sigungu가 하나의 Region에 속함
    @ManyToOne
    private Area area;
}

