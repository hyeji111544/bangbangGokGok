package green.mtcoding.travel.domain.tourmap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TourmapController {

    @GetMapping("/tourmap")
    public String tourmap() {
        return "/tourmap/tourmap";
    }
}
