package green.mtcoding.travel.global.util;

import green.mtcoding.travel.global.error.ex.Exception500;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class MyFile {

    //파일저장
    public static String filesave(MultipartFile file) {
        UUID uuid = UUID.randomUUID();
        String fileName = uuid+"_"+file.getOriginalFilename();//롤링'
        System.out.println("롤링"+fileName);

        Path imageFilePath = Paths.get("./profileimg/"+fileName);
        System.out.println("롤링 후 "+imageFilePath);
        try {
            Files.write(imageFilePath, file.getBytes());
            System.out.println("롤링 후후후" + imageFilePath);
        }catch (Exception e) {
            throw new Exception500("파일 저장 오류");
        }
        return fileName;
    }
}
