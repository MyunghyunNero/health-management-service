package healthmanagementservice2.healthmanagementservice2.controller;

import healthmanagementservice2.healthmanagementservice2.Login.SessionConst;
import healthmanagementservice2.healthmanagementservice2.domain.Health;
import healthmanagementservice2.healthmanagementservice2.domain.Location;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.service.HealthService;
import healthmanagementservice2.healthmanagementservice2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/healths")
public class HealthController {
    private final HealthService healthService;
    private final MemberService memberService;

    @ModelAttribute("locationtype")
    public Location[] locations(){
        return Location.values();
    }

    @GetMapping
    public String healths(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
                                      Member loginmember,Model model){
        List<Health> healths =healthService.findAll(loginmember.getId());
        model.addAttribute("healths",healths);
        return "healths/healths";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("health",new Health());
        return "healths/addForm";
    }
    @PostMapping("/add")
    public String add(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
                                  Member loginmember, @ModelAttribute Health health){
        healthService.sign(loginmember.getId(), health);
        return "redirect:/";
    }
    @GetMapping("{location}")
    public String divlocation(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
            Member loginmember,@PathVariable Location location,Model model){
        List<Health> healthbylocation = healthService.findByLocation(location, loginmember.getId());
        model.addAttribute("healthbylocation", healthbylocation);
        return "healths/location";
    }
    @GetMapping("/{healthnum}/edit")
    public String editForm(@PathVariable Long healthnum, Model model) {
        Health health = healthService.findbyId(healthnum);
        model.addAttribute("health", health);
        return "healths/editForm";
    }
    @PostMapping("/update")
    public String edit(@ModelAttribute Health health) {
        healthService.updateHealth(health.getId(),health.getExercisetime(),health.getExerciseName(),health.getHealthset(), health.getHealthcount());
        return "redirect:/healths";
    }
    @GetMapping("/{healthnum}/delete")
    public String delete(@PathVariable Long healthnum, Model model){
        healthService.delete(healthnum);
        return "redirect:/healths";
    }
    @GetMapping("/{healthnum}/state")
    public String state(@PathVariable Long healthnum ){
        healthService.finishexercise(healthnum);
        return "redirect:/healths";
    }
}
