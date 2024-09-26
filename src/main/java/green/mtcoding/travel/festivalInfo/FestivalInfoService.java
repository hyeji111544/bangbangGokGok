package green.mtcoding.travel.festivalInfo;

import green.mtcoding.travel.content.ContentRepository;
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
    private final ContentRepository contentRepository;

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
        // 1. 조회 후 festivalInfo_tb 에 존재하면 데이터 리턴 / 없으면 저장 후 저장한 데이터 리턴
        try {
            FestivalInfo festivalInfoPS = festivalInfoRepository.findByContentId(saveDTO.getContentId());
            System.out.println(festivalInfoPS);
            return new FestivalInfoResponse.FestivalDetailDTO(festivalInfoPS);
        } catch (Exception e) {
            festivalInfoRepository.save(saveDTO.toEntity()); // 담궈지는 순간, 만들어진다.
            FestivalInfo festivalInfoPS = festivalInfoRepository.findByContentId(saveDTO.getContentId());
            return new FestivalInfoResponse.FestivalDetailDTO(festivalInfoPS);
        }
    }
    @Transactional
    public void saveFestivalDataForScrap(FestivalInfoRequest.SaveDTO saveDTO) {
        // 1. 조회 후 content_TB 에 없는 축제 정보면 등록
        try {
           if (contentRepository.findByContentTypeIdAndContentId(saveDTO.getContentTypeId(), saveDTO.getContentId()) != null) {
               System.out.println("Content_TB 에 있는 축제정보, 스크랩에 문제 없음");
           }
        } catch (Exception e) {
            // String contentId, String addr1, String areaCode, String contentTypeId, String firstImage, String sigunguCode, String title
            System.out.println("Null Exception 발생, Content_TB 에 축제정보 저장");
            contentRepository.save(saveDTO.getContentId(), saveDTO.getAddr1(), saveDTO.getAreaCode(), saveDTO.getContentTypeId(), saveDTO.getFirstImage(), saveDTO.getSigunguCode(), saveDTO.getTitle());
        }
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
