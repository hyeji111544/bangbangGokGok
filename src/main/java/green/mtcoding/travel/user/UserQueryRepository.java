package green.mtcoding.travel.user;

import green.mtcoding.travel.scrap.Scrap;
import green.mtcoding.travel.scrap.ScrapResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserQueryRepository {

    private final EntityManager em;

    // 마이페이지 유저 정보 긁어오기
    public List<User> userFindById(int id) {
        Query query = em.createNativeQuery("select * from user_tb where id = ?");
        query.setParameter(1, id);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<User> userInfo = mapper.list(query, User.class);
        return userInfo;
    }
    // 마이페이지 유저 스크랩 긁어오기
    public List<UserResponse.MypageListDTO.ScrapDTO> scrapFindById(int id) {
        Query query = em.createNativeQuery("select * from user_tb u join scrap_tb s on u.id = s.user_id where u.id = ?");
        query.setParameter(1, id);
        JpaResultMapper mapper = new JpaResultMapper(); // 이게 없으면 List를 불러올때 객체로 받아서 인식이 안됨
        List<UserResponse.MypageListDTO.ScrapDTO> scrapList = mapper.list(query, UserResponse.MypageListDTO.ScrapDTO.class);
        return scrapList;
    }

}
