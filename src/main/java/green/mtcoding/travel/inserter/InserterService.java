package green.mtcoding.travel.inserter;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import green.mtcoding.travel.global.error.ex.Exception404;
import green.mtcoding.travel.inserter.entity.Area;
import green.mtcoding.travel.inserter.entity.Sigungu;
import green.mtcoding.travel.inserter.entity.Content;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RequiredArgsConstructor
@Service
public class
InserterService {

    private final EntityManager em;
    private final InserterRepository inserterRepository;
    private final ObjectMapper objectMapper;





    @Transactional
    public void init() throws Exception {
        //objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

        // 엔티티와 파일 매핑 설정
        Map<String, TypeReference<?>> fileToEntityMap = new HashMap<>();

        fileToEntityMap.put("/json/tourist+festival+food.json", new TypeReference<List<Content>>() {});
        fileToEntityMap.put("/json/area.json", new TypeReference<List<Area>>() {});

        // 파일별 처리
        for (Map.Entry<String, TypeReference<?>> entry : fileToEntityMap.entrySet()) {
            TypeReference<List<Object>> typeRef = (TypeReference<List<Object>>) entry.getValue();
            saveEntities(entry.getKey(), typeRef);
        }

    }



    private <T> void saveEntities(String filePath, TypeReference<List<T>> typeReference) throws Exception {
        ClassPathResource resource = new ClassPathResource(filePath);
        try (InputStream inputStream = resource.getInputStream()) {
            // JSON 데이터를 Map으로 읽기
            Map<String, Object> jsonMap = objectMapper.readValue(inputStream, Map.class);
            Map<String, Object> response = (Map<String, Object>) jsonMap.get("response");
            Map<String, Object> header = (Map<String, Object>) response.get("header");
            String resultMsg = (String) header.get("resultMsg");

            // resultMsg가 "OK"일 때만 처리
            if (resultMsg.equals("OK")) {
                Map<String, Object> body = (Map<String, Object>) response.get("body");
                Map<String, Object> items = (Map<String, Object>) body.get("items");
                List<T> entities = objectMapper.convertValue(items.get("item"), typeReference);
                inserterRepository.saveAll(entities);
            } else {
                throw new Exception404("json 파일이 존재하지 않습니다.");
            }
        }



    }



    @Transactional
    public  void jsonTest() {
        Area area = new Area();
        area.setCode("1");
        area.setName("서울");

        em.persist(area);
        System.out.println("area = " + area);

        Sigungu sigungu = new Sigungu();
        sigungu.setCode("1");
        sigungu.setName("강남구");
        sigungu.setArea(area);

        em.persist(sigungu);
        System.out.println("sigungu = " + sigungu);

    }


        // 특정 경로의 json 파일 불러서 파싱
        @Transactional
        public void init2() throws Exception {
            try {
                //   /json/sigungu 폴더의 모든 파일을 읽음
                File folder = new ClassPathResource("json/sigungu").getFile();
                File[] files = folder.listFiles();

                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(".json")) {
                            // Sigungu 데이터 파일 처리
                            insertSigunguData(file);
                        }
                    }
                } else {
                    throw new Exception404("json 파일이 존재하지 않습니다.");
                }
            } catch (IOException e) {
                System.out.println("폴더를 읽는 중 에러가 발생했습니다.");
                e.printStackTrace();
            }


        }

        public void insertSigunguData(File jsonFile) {
            // 파일 이름에서 앞 두 자리를 추출하여 areacode로 설정
            String fileName = jsonFile.getName();
            String areacode = fileName.substring(0, 2);  // 파일 이름의 앞 두 자리 추출

            if (areacode.startsWith("0")) {
                areacode = areacode.substring(1);  // 앞의 '0' 제거
            }

            // 추출한 areacode로 Region을 조회
            Area area = inserterRepository.findByCode(areacode);

            if (area != null) {
                // JSON 파일 파싱 후 Sigungu 데이터 리스트 생성
                List<Sigungu> sigunguList = parseJsonFile(jsonFile);

                // 각 Sigungu 객체에 Area 객체를 설정하고 persist 처리
                for (Sigungu sigungu : sigunguList) {
                    // Sigungu 객체에 Area 설정
                    sigungu.setArea(area);

                    // Sigungu 데이터 저장
                    em.persist(sigungu);  // 엔티티 매니저로 persist
                }
            } else {
                throw new Exception404("해당 areacode를 가진 Region이 없습니다.");
            }
        }

        // JSON 파싱 메서드
        private List<Sigungu> parseJsonFile(File jsonFile) {
            // JSON 파일을 파싱하여 Sigungu 객체 리스트 반환
            ObjectMapper objectMapper = new ObjectMapper();
            List<Sigungu> sigunguList = new ArrayList<>();

            try {
                JsonNode rootNode = objectMapper.readTree(jsonFile);
                JsonNode items = rootNode.path("response").path("body").path("items").path("item");

                for (JsonNode item : items) {
                    Sigungu sigungu = new Sigungu();
                    sigungu.setCode(item.get("code").asText());
                    sigungu.setName(item.get("name").asText());
                    sigunguList.add(sigungu);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return sigunguList;
        }


}

