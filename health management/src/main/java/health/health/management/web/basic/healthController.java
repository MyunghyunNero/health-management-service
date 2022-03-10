package health.health.management.web.basic;


import health.health.management.domain.healthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic/healths")
@RequiredArgsConstructor
public class healthController {

    private final healthRepository healthRepository =  new healthRepository();
}
