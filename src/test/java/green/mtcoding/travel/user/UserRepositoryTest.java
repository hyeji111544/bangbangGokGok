package green.mtcoding.travel.user;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@DataJpaTest
@Import(UserRepository.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void save_test() {
        // User 정보 설정
        String loginId = "ssar";
        String password = "1234";
        String profile = "null";
        String nickName = "hapssar";
        String email = "ssar@nate.com";
        String phone = "010-1234-5678";

        // 빌더 패턴을 사용하여 User 객체 생성 (id 제외)
        User user = User.builder()
                .loginId(loginId)
                .password(password)
                .profile(profile)
                .nickName(nickName)
                .email(email)
                .phone(phone)
                .build();

        // User 저장
        userRepository.save(user);
    }
}
