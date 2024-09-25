package green.mtcoding.travel.review;

import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class ReviewResponse {

    // r.id, r.context, r.created_at, r.rating, u.nick_name
    @Data
    public static class detailReviewDTO{
        private int id;
        private String context;
        private Timestamp createdAt;
        private double rating;
        private String nickname;
        private String profile;

        public detailReviewDTO(int id, String context, Timestamp createdAt, double rating, String nickname, String profile) {
            this.id = id;
            this.context = context;
            this.createdAt = createdAt;
            this.rating = rating;
            this.nickname = nickname;
            this.profile = profile;
        }

        // 별점 문자열 생성 메서드 추가
        public String getStarRating() {
            int fullStars = (int) rating / 1;  // 1점당 0.5 단위이므로 2로 나눔
            boolean hasHalfStar = (rating % 1 != 0);  // 0.5 별 여부

            StringBuilder stars = new StringBuilder();

            // 가득 찬 별 추가
            for (int i = 0; i < fullStars; i++) {
                stars.append("★");
            }

            // 반 개의 별 추가
            if (hasHalfStar) {
                stars.append("☆");  // 반개를 '☆'로 표현하거나 CSS로 처리
            }

            // 빈 별 채우기 (총 5개의 별)
            /*
            for (int i = fullStars + (hasHalfStar ? 1 : 0); i < 5; i++) {
                stars.append("☆");
            }*/

            return stars.toString();
        }

        // 헬퍼 메서드: Timestamp를 yyyy-MM-dd 형식으로 변환
        public String getFormattedCreatedAt() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(createdAt);
        }
    }

    @Data
    public static class DTO{
        private Integer id;
        private String context;
        private boolean isDeleted;
        private double rating;
        private String nickname;

        public DTO(Review review) {
            this.id = review.getId();
            this.context = review.getContext();
            this.isDeleted = review.isDeleted();
            this.rating = review.getRating();
            this.nickname = review.getUser().getNickName();
        }
    }

    @Data
    public static class MypageReviewDTO{
        private List<ReviewResponse.ReviewListDTO> reviewList;
        private List<ReviewResponse.MypageUserDTO> userInfo;

        public MypageReviewDTO(List<ReviewResponse.ReviewListDTO> reviewList, List<ReviewResponse.MypageUserDTO> userInfo) {
            this.reviewList = reviewList;
            this.userInfo = userInfo;
        }
    }

    @Data
    public static class MypageUserDTO{
        private int id;
        private String nickname;
        private String profile;

        public MypageUserDTO(int id, String nickname, String profile) {
            this.id = id;
            this.nickname = nickname;
            this.profile = profile;
        }
    }

    @Data
    public static class ReviewListDTO {

        private int id;
        private String contentId;
        private String contentTypeId;
        private String title;
        private String addr1;
        private String context;
        private Timestamp createdAt;
        private double rating;
        private boolean isFestival;

        public ReviewListDTO(int id, String contentId, String contentTypeId, String title, String addr1, String context, Timestamp createdAt, double rating) {
            this.id = id;
            this.contentId = contentId;
            this.contentTypeId = contentTypeId;
            this.title = title;
            this.addr1 = addr1;
            this.context = context;
            this.createdAt = createdAt;
            this.rating = rating;
            this.isFestival = false;

            if(contentTypeId.equals("15")){
                this.isFestival = true;
            }
        }

        // 별점 문자열 생성 메서드 추가
        public String getStarRating() {
            int fullStars = (int) rating / 1;  // 1점당 0.5 단위이므로 2로 나눔
            boolean hasHalfStar = (rating % 1 != 0);  // 0.5 별 여부

            StringBuilder stars = new StringBuilder();

            // 가득 찬 별 추가
            for (int i = 0; i < fullStars; i++) {
                stars.append("★");
            }

            // 반 개의 별 추가
            if (hasHalfStar) {
                stars.append("☆");  // 반개를 '☆'로 표현하거나 CSS로 처리
            }

            // 빈 별 채우기 (총 5개의 별)
            /*
            for (int i = fullStars + (hasHalfStar ? 1 : 0); i < 5; i++) {
                stars.append("☆");
            }*/

            return stars.toString();
        }

        // 헬퍼 메서드: Timestamp를 yyyy-MM-dd 형식으로 변환
        public String getFormattedCreatedAt() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(createdAt);
        }


    }

}
