package healthmanagementservice2.healthmanagementservice2.controller;

import healthmanagementservice2.healthmanagementservice2.Login.SessionConst;
import healthmanagementservice2.healthmanagementservice2.domain.Health;
import healthmanagementservice2.healthmanagementservice2.domain.Location;
import healthmanagementservice2.healthmanagementservice2.domain.Member;
import healthmanagementservice2.healthmanagementservice2.domain.form.HealthForm;
import healthmanagementservice2.healthmanagementservice2.service.HealthService;
import healthmanagementservice2.healthmanagementservice2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @PostMapping
    public String posthealths(){
        return "redirect:/healths";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("healthform",new HealthForm());
        return "healths/addForm";
    }
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("healthform") HealthForm healthform,BindingResult bindingResult,@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
                                  Member loginmember){
        if(bindingResult.hasErrors()){
            return "healths/addForm";
        }
        Health health=new Health();
        health.setExerciseName(healthform.getExerciseName());
        health.setHealthset(healthform.getHealthset());
        health.setHealthcount(healthform.getHealthcount());
        health.setExercisetime(healthform.getExercisetime());
        health.setExerciseLocation(healthform.getExerciseLocation());
        health.setExercisestate("done?");
        healthService.sign(loginmember.getId(), health);
        return "redirect:/";
    }
    @GetMapping("{location}")
    public String divlocation(@SessionAttribute(name = SessionConst.LOGIN_MEMBER,required = false)
            Member loginmember,@PathVariable("location") Location location,Model model){
        List<Health> healthbylocation = healthService.findByLocation(location, loginmember.getId());
        model.addAttribute("healthbylocation", healthbylocation);
        return "healths/location";
    }
    @GetMapping("/{healthnum}/edit")
    public String editForm(@PathVariable("healthnum") Long healthnum, Model model) {
        Health health = healthService.findbyId(healthnum);
        HealthForm healthForm=new HealthForm();
        healthForm.setId(health.getId());
        healthForm.setHealthcount(health.getHealthcount());
        healthForm.setHealthset(health.getHealthset());
        healthForm.setExerciseLocation(health.getExerciseLocation());
        healthForm.setExercisestate(health.getExercisestate());
        healthForm.setExercisetime(health.getExercisetime());
        healthForm.setExerciseName(health.getExerciseName());
        model.addAttribute("healthForm", healthForm);
        return "healths/editForm";
    }
    @PostMapping("/{healthnum}/edit")
    public String edit(@Valid @ModelAttribute HealthForm healthForm, BindingResult bindingResult,@PathVariable Long healthnum) {
        if(bindingResult.hasErrors()){
            return "healths/editForm";
        }
        healthService.updateHealth(healthForm.getId(), healthForm.getExercisetime(),healthForm.getExerciseName(),healthForm.getHealthset(), healthForm.getHealthcount());
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
