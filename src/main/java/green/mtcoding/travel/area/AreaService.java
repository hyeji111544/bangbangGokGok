package green.mtcoding.travel.area;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AreaService {

    private final AreaRepository areaRepository;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    public AreaResponse.AreaDTO 시군구리스트가져오기(String areaCode) {
        Area area = areaRepository.findByArea(areaCode);
        AreaResponse.AreaDTO areaDTO = new AreaResponse.AreaDTO(area);
        return areaDTO;
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
