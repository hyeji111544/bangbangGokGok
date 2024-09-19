package green.mtcoding.travel.area;

import green.mtcoding.travel.sigungu.Sigungu;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "area_tb")
public class Area {

    @Id
    private String code;  // 지역 코드
    private String name;  // 지역 이름

    // OneToMany: 여러 Sigungu가 이 Region에 속함
    @OneToMany(mappedBy = "area", fetch = FetchType.LAZY)
    private List<Sigungu> sigungus;


}