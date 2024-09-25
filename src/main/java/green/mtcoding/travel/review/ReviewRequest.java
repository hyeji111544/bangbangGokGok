package green.mtcoding.travel.review;

import green.mtcoding.travel.content.Content;
import green.mtcoding.travel.user.User;
import lombok.Data;

public class ReviewRequest {

        @Data
        public static class SaveDTO {
            private int contentId;
            private String context;
            private double rating;

            // insert into review_tb(user_id, is_deleted, context, content_id_content_id, festival_info_content_id, rating)

            public Review toEntity(User sessionUser, Content content) {
                return Review.builder()
                        .context(context)
                        .user(sessionUser)
                        .contentId(content)
                        .rating(rating)
                        .build();
            }
        }

}
