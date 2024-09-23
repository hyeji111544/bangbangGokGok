package green.mtcoding.travel.countinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class CountInfoController {

    private final CountInfoService countInfoService;

}
