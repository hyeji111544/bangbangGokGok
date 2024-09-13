package green.mtcoding.travel.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

@Controller
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

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
    public User login(UserRequest.LoginDTO loginDTO){
        User user = userRepository.findByLoginIdAndPassword(loginDTO.getLoginId(), loginDTO.getPassword());
        return user;
    }

    /*           user-end             */

    /*           myPage-start             */
    /*           myPage-end             */
}
