package green.mtcoding.travel.user;

import green.mtcoding.travel.review.Review;
import green.mtcoding.travel.scrap.Scrap;
import lombok.Data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserResponse {

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
    public static class MypageScrapDTO{
        private int id;
        private boolean isScrap;
        private String contentId;
        private String contentTypeId;
        private String title;
        private String addr1;
        private String firstImage;

        public MypageScrapDTO(int id, boolean isScrap, String contentId, String contentTypeId, String title, String addr1, String firstImage) {
            this.id = id;
            this.isScrap = isScrap;
            this.contentId = contentId;
            this.contentTypeId = contentTypeId;
            this.title = title;
            this.addr1 = addr1;
            this.firstImage = firstImage;
        }
    }

    @Data
    public static class MypageReviewDTO{
        private int id;
        private String contentId;
        private String contentTypeId;
        private String title;
        private String addr1;
        private String context;
        private Timestamp createdAt;
        private double rating;
        private boolean isFestival;

        public MypageReviewDTO(int id, String contentId, String contentTypeId, String title, String addr1, String context, Timestamp createdAt, double rating) {
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

    @Data
    public static class MypageListDTO {

        private int id;
        private String username;
        private String profile;
        private int reviewTotal;
        private int scrapTotal;
        private List<ScrapDTO> scraps = new ArrayList<>();
        private List<ReviewDTO> reviews = new ArrayList<>();

        @Data
        class ScrapDTO {
            private int id;
            private String title;
            private String contentId;
            private String contentTypeId;
            private String firstImage;

            public ScrapDTO(Scrap scrap) {
                this.id = scrap.getId();
                this.title = scrap.getContent().getTitle();
                this.contentId = scrap.getContent().getContentId();
                this.contentTypeId = scrap.getContent().getContentTypeId();
                this.firstImage = scrap.getContent().getFirstImage();
            }
        }

        @Data
        class ReviewDTO {
            private int id;
            private String title;
            private String contentId;
            private String contentTypeId;
            private String firstImage;
            private String context;
            private Timestamp createdAt;
            private double rating;

            public ReviewDTO(Review review) {
                this.id = review.getId();
                this.title = review.getContentId().getTitle();
                this.contentId = review.getContentId().getContentId();
                this.contentTypeId = review.getContentId().getContentTypeId();
                this.firstImage = review.getContentId().getFirstImage();
                this.context = review.getContext();
                this.createdAt = review.getCreatedAt();
                this.rating = review.getRating();
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

        public MypageListDTO(int id, String username, String profile) {

        }

        public MypageListDTO(User user) {
            this.id = user.getId();
            this.username = user.getNickName();
            this.profile = user.getProfile();
            this.reviewTotal = reviews.size();
            this.scrapTotal = scraps.size();

            for (Scrap scrap : user.getScraps()) {
                scraps.add(new ScrapDTO(scrap));
            }

            for (Review review : user.getReviews()) {
                reviews.add(new ReviewDTO(review));
            }
        }
    }

    @Data
    public static class DTO {
        private Long countScrap;
        private Long countReview;
        private List<UserResponse.MypageScrapDTO> scrapList;
        private List<UserResponse.MypageReviewDTO> reviewList;
        private List<UserResponse.MypageUserDTO> userInfo;

        public DTO(Long countScrap, Long countReview, List<MypageScrapDTO> scrapList, List<MypageReviewDTO> reviewList, List<MypageUserDTO> userInfo) {
            this.countScrap = countScrap;
            this.countReview = countReview;
            this.scrapList = scrapList;
            this.reviewList = reviewList;
            this.userInfo = userInfo;
        }
    }
}
