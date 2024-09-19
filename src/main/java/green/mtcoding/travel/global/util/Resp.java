package green.mtcoding.travel.global.util;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Resp<T> {
    private Integer status;
    private String msg;
    private T body;

    public static <B> Resp<?> ok(B body){
        return new Resp<>(200, "성공", body);
    }

    public static Resp<?> fail(Integer status, String msg){
        return new Resp<>(status, msg, null);
    }


    // 아이디 중복 확인을 위한 ok 메서드
    public static Resp<?> ok(boolean isSameloginId, String s) {
        // 중복 여부와 메시지를 반환하는 응답 객체 생성
        return new Resp<>(200, s, isSameloginId);
    }

}