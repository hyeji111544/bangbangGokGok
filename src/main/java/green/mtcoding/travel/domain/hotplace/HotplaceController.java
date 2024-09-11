package green.mtcoding.travel.domain.hotplace;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HotplaceController {

    @GetMapping("/hotplace")
    public String hotplace() {
        return "/hotplace/hotplace";
    }
}
