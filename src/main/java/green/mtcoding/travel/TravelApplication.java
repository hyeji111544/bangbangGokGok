package green.mtcoding.travel;

import green.mtcoding.travel.global.util.SHA256;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class TravelApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelApplication.class, args);


        try {
            System.out.println("123 - sha256 : " + SHA256.encrypt("123"));
            System.out.println("123 - sha256 : " + SHA256.encrypt("123"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }
}
