package healthmanagementservice2.healthmanagementservice2.controller;

import healthmanagementservice2.healthmanagementservice2.service.HealthService;
import healthmanagementservice2.healthmanagementservice2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/healths")
public class HealthController {
    private final HealthService healthService;
    private final MemberService memberService;
}
