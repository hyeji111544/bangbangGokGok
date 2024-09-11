package green.mtcoding.travel.domain.info;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class InfoController {



    @GetMapping("/info")
    public String info() {
        return "/info/info";
    }

    @GetMapping("/info/detail")
    public String detail() {
        return "/info/detail";
    }
}
