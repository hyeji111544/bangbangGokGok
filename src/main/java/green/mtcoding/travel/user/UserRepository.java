package green.mtcoding.travel.user;

import green.mtcoding.travel.global.error.ex.Exception401;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager em;

    //유저네임로 조회
    public User findByLoginId(String loginId) {
        Query query = em.createQuery("select u  from User u where u.loginId=:loginId", User.class);
        query.setParameter("loginId", loginId);
        try {
            User user = (User) query.getSingleResult();
            return user;

        } catch (Exception e) {

            return null;
        }


    }

    //로그인(401 여기서 터트리기)
    public User findByLoginIdAndPassword(String loginId, String password) throws NoResultException {
        Query query = em.createQuery("select u from User u where u.loginId=:loginId and u.password=:password", User.class);
        query.setParameter("loginId", loginId);
        query.setParameter("password", password);

        try {
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {


            // e.getmsg는 해주면 안된다. 서버 노출이 된다.
            throw new Exception401("인증되지 않았습니다.");


        }
    }

    public void save(User user) {

    }

}
