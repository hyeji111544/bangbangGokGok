package green.mtcoding.travel.domain.region;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

}
