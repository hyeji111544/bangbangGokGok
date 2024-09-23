package green.mtcoding.travel.festivalInfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class FestivalInfoService {

    private final FestivalInfoRepository festivalInfoRepository;

    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    /*           hotPlace-end             */

    /*           festival-start             */
    public List<FestivalInfoResponse.FestivalMainDTO> 목록보기() {
        List<FestivalInfoResponse.FestivalMainDTO> festivalInfoList = festivalInfoRepository.findAll();

        // index 값 설정
        for (int i = 0; i < festivalInfoList.size(); i++) {
            FestivalInfoResponse.FestivalMainDTO dto = festivalInfoList.get(i);
            dto.setIndex(i);
            // 첫 번째 항목에 active 값 설정
            dto.setActive(i == 0); // 0 일때만 true 반환
        }

        return festivalInfoList;
    }
    @Transactional
    public FestivalInfoResponse.FestivalDetailDTO saveFestivalData(FestivalInfoRequest.SaveDTO saveDTO) {
        // 1. 조회 후 없으면 등록
        try {
            FestivalInfo festivalInfoPS = festivalInfoRepository.findByContentId(saveDTO.getContentId());
        } catch (Exception e) {
            festivalInfoRepository.save(saveDTO.toEntity()); // 담궈지는 순간, 만들어진다.
            FestivalInfo festivalInfoPS = festivalInfoRepository.findByContentId(saveDTO.getContentId());
            return new FestivalInfoResponse.FestivalDetailDTO(festivalInfoPS);
        }
        return null;
    }
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
