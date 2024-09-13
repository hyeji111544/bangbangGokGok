package green.mtcoding.travel.user;

import green.mtcoding.travel.global.error.ex.Exception400;
import green.mtcoding.travel.global.error.ex.Exception404;
import green.mtcoding.travel.global.util.MyFile;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
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
        User userid = userRepository.findByUserId(joinDTO.getLoginId());
        User usernick = userRepository.findByUsernickName(joinDTO.getNickName());

        if (userid != null || usernick != null) {
            throw new Exception400("이미 존재하고 있는 ID와 NICKNAME 입니다.");
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

    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}

