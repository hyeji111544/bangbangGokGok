package green.mtcoding.travel.area;


import green.mtcoding.travel.sigungu.Sigungu;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class AreaResponse {

    @Data
    public static class DetailDTO {
        private String code;
        private String name;

        private List<SigunguDTO> sigungus = new ArrayList<>();

        public DetailDTO(Area area) {
            this.code = area.getCode();
            this.name = area.getName();
            for (Sigungu sigungu : area.getSigungus()) {
                sigungus.add(new SigunguDTO(sigungu));
            }
        }

        @Data
        class SigunguDTO {
            private Integer id;
            private String code;
            private String name;

            public SigunguDTO(Sigungu sigungu) {
                this.id = sigungu.getId();
                this.code = sigungu.getCode();
                this.name = sigungu.getName();
            }
        }

    }

}
