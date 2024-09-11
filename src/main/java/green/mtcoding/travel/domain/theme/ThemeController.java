package green.mtcoding.travel.domain.theme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ThemeController {

    @GetMapping("/theme")
    public String theme() {
        return "/theme/theme";
    }
}
