package green.mtcoding.travel.user;


import green.mtcoding.travel.global.error.ex.Exception400;
import green.mtcoding.travel.global.error.ex.Exception404;
import green.mtcoding.travel.global.util.MyFile;
import green.mtcoding.travel.review.Review;
import green.mtcoding.travel.scrap.Scrap;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserQueryRepository userQueryRepository;
    private final EntityManager em;


    /*           main-start             */
    /*           main-end             */

    /*           theme-start             */
    /*           theme-end             */

    /*           region-start             */
    /*           region-end             */

    /*           hotPlace-start             */
    /*           hotPlace-end             */

    /*           festival-start             */
    /*           festival-end             */

    /*           info-start             */
    /*           info-end             */

    /*           map-start             */
    /*           map-end             */

    /*           user-start             */
    //로그인
    @Transactional
    public User login(UserRequest.LoginDTO loginDTO) {
        User user = userRepository.findByLoginIdAndPassword(loginDTO.getLoginId(), loginDTO.getPassword());
        return user;
    }


    //회원가입
    @Transactional
    public void registuser(UserRequest.JoinDTO joinDTO, MultipartFile profile) {
        Optional<User> loginId = userRepository.findByUserId(joinDTO.getLoginId());
        Optional<User> nickName = userRepository.findByUsernickName(joinDTO.getNickName());
        System.out.println("123123213132"+nickName.isPresent());

        if (loginId.isPresent()) {
            throw new Exception400("이미 존재하는 ID 입니다.");
        }

        if (nickName.isPresent()) {
            throw new Exception400("이미 존재하는 NICKNAME 입니다.");
        }

        User newUser = joinDTO.toEntity();

        // 3. 프로필 이미지 업로드 처리
        if (profile != null && !profile.isEmpty()) {
            String imageFileName = MyFile.filesave(profile); // 파일 저장 로직
            System.out.println("유저서비스1 "+imageFileName);
            newUser.setProfile("/profileimg/"+imageFileName); // 프로필 이미지 설정
            System.out.println("유저서비스2 "+newUser.getProfile());
        }
        else {
            // 파일이 없으면 기본 이미지 설정
            String defaultImagePath = "/profileimg/man_img.png";  // 예: 남성 이미지를 기본으로 설정
            System.out.println("유저 서비스3 " + defaultImagePath);

            newUser.setProfile(defaultImagePath); // 기본 프로필 이미지 파일명 설정
        }

        userRepository.save(newUser);
    }

    //아이디 중복확인
    public boolean loginIdcheck(String loginId) {
        Optional<User> userOP = userRepository.findByUserId(loginId);
        if (userOP.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }
    //닉네임 중복확인
    public boolean nickNamcheck(String nickName) {
        Optional<User> userOP = userRepository.findByUsernickName(nickName);
        if (userOP.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }


    /*           user-end             */

    /*           myPage-start             */

    // 마이페이지 스크랩 개수
    public Long selectMypageCountScrap(User session) {
        int id = session.getId();
        Long countScrap = userQueryRepository.countScrapById(id);
        return countScrap;
    }
    // 마이페이지 스크랩 리스트
    public List<UserResponse.MypageScrapDTO> selectMypageScrapList(User session) {
        int id = session.getId();
        List<UserResponse.MypageScrapDTO> scrapList = userQueryRepository.scrapFindById(id);
        return scrapList;
    }
    // 마이페이지 리뷰 개수
    public Long selectMypageCountReview(User session) {
        int id = session.getId();
        Long countReview = userQueryRepository.countReviewById(id);
        return countReview;
    }
    // 마이페이지 스크랩 리스트
    public List<UserResponse.MypageReviewDTO> selectMypageReviewList(User session) {
        int id = session.getId();
        List<UserResponse.MypageReviewDTO> reviewList = userQueryRepository.reviewFindById(id);
        return reviewList;
    }


    /*           myPage-end             */
}

