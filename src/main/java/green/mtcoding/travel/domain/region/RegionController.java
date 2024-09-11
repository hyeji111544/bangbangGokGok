package green.mtcoding.travel.domain.region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/region")
    public String area() {
        return "/region/region";
    }
}
