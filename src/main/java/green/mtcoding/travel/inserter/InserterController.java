package green.mtcoding.travel.inserter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class InserterController {

    private final InserterService inserterService;




    @ResponseBody
    @GetMapping("/data/insert")
    public String index() throws Exception {
        inserterService.init();
        inserterService.init2();
        return "data insert ok";
    }













}
