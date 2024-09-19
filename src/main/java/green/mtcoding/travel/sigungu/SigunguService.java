package green.mtcoding.travel.sigungu;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class SigunguService {

    private final SigunguRepository sigunguRepository;



    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */

    public List<SigunguResponse.SigunguDTO> 시군구리스트가져오기(String area) {
        List<Sigungu> sigunguList = sigunguRepository.findByArea(area);
        List<SigunguResponse.SigunguDTO> dtoList = new ArrayList<>();
        for (Sigungu sigungu : sigunguList) {
            dtoList.add(new SigunguResponse.SigunguDTO(sigungu));
        }
        return dtoList;
    }

    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */
    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */
    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}
