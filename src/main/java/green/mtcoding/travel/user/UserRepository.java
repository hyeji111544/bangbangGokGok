package green.mtcoding.travel.user;

import green.mtcoding.travel.global.error.ex.Exception401;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final EntityManager em;

    //ID 레파지토리

    public User findById(Integer id){
        Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        try{
            User user = (User) query.getSingleResult();
            return user;
        }
        catch(Exception e){

            return null;
        }
    }

    //회원가입 중복확인(loignId)
    public Optional<User> findByUserId(String loginId) {
        Query query = em.createQuery("select u  from User u where u.loginId=:loginId", User.class);
        query.setParameter("loginId", loginId);
        try {
            User user = (User) query.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {

            return Optional.empty();
        }
    }
    //회원가입 중복확인(nickName)
    public Optional<User> findByUsernickName(String nickName) {
        Query query = em.createQuery("select u  from User u where u.nickName=:nickName", User.class);
        query.setParameter("nickName", nickName);
        try {
            User user = (User) query.getSingleResult();
            return Optional.of(user);
        } catch (Exception e) {

            return Optional.empty();
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


    //회원가입
    public void save(User user) {
        System.out.println("담기전"+user.getId());
        System.out.println("담기전"+user.getPassword());
        System.out.println("담기전"+user.getProfile());
        System.out.println("담기전"+user.getNickName());
        System.out.println("담기전"+user.getEmail());
        System.out.println("담기전"+user.getPhone());
        em.persist(user);
        System.out.println("담기후"+user.getId());
        System.out.println("담기후"+user.getPassword());
        System.out.println("담기후"+user.getProfile());
        System.out.println("담기후"+user.getNickName());
        System.out.println("담기후"+user.getEmail());
        System.out.println("담기후"+user.getPhone());


    }

}
