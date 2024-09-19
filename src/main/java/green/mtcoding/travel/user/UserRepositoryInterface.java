package green.mtcoding.travel.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepositoryInterface  extends JpaRepository<User, Integer> {

    //로그인 UserRepository Interface로 만들기
    @Query("select u from User u where u.loginId = :loginId and u.password = :password")
    Optional<User> findByLoginIdAndPassword(@Param("loginId") String loginId, @Param("password") String password);



}
