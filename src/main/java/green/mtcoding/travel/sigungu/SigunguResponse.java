package green.mtcoding.travel.sigungu;

import green.mtcoding.travel.area.Area;
import lombok.Data;

import java.util.List;

public class SigunguResponse {

    @Data
    public static class SigunguDTO {
        private Integer id;
        private String name;
        private String code;
        private AreaDTO area;

        public SigunguDTO(Sigungu sigungu) {
            this.id = sigungu.getId();
            this.name = sigungu.getName();
            this.code = sigungu.getCode();
            this.area = new AreaDTO(sigungu.getArea());
        }

        @Data
        public class AreaDTO {
            private String code;
            private String name;

            public AreaDTO(Area area) {
                this.code = area.getCode();
                this.name = area.getName();
            }
        }
    }
}
