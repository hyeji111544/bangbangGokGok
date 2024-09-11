package green.mtcoding.travel.domain.festival;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class FestivalService {

    private final FestivalRepository festivalRepository;

}
