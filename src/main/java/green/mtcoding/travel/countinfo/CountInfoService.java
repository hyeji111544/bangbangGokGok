package green.mtcoding.travel.countinfo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CountInfoService {

    private final CountInfoRepository countInfoRepository;

}
