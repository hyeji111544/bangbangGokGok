package green.mtcoding.travel.domain.festival;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FestivalController {

    private final FestivalRepository festivalRepository;

    @GetMapping("/festival")
    public String festival() {
        return "/festival/festival";
    }
}
