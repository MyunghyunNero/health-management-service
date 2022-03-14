package health.health.management.web.basic;


import health.health.management.domain.Health;
import health.health.management.domain.healthRepository;
import health.health.management.domain.type.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/healths")
@RequiredArgsConstructor
public class healthController {

    private final healthRepository healthRepository =  new healthRepository();

    @ModelAttribute("locationtype")
    public Location[] locations(){
        return Location.values();
    }

    @GetMapping
    public String healths(Model model){
        List<Health> healths =healthRepository.findAll();
        model.addAttribute("healths",healths);
        return "basic/healths";
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("Health",new Health());
        return "basic/addForm";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute Health health){
        healthRepository.save(health);
        return "redirect:/basic/healths";
    }
    @GetMapping("{location}")
    public String divlocation(@PathVariable String location,Model model){
        List<Health> healthbylocation = healthRepository.findByLocation(location);
        model.addAttribute("healthbylocation", healthbylocation);
        return "basic/location";
    }
    @GetMapping("/{healthnum}/edit")
    public String editForm(@PathVariable Long healthnum, Model model) {
        Health health = healthRepository.findById(healthnum);
        model.addAttribute("health", health);
        return "basic/editForm";
    }
    @PostMapping("/{healthnum}/edit")
    public String edit(@PathVariable Long healthnum, @ModelAttribute Health health) {
        healthRepository.update(healthnum, health);
        return "redirect:/basic/healths";
    }
    @GetMapping("{healthnum}/delete")
    public String delete(@PathVariable Long healthnum, Model model){
        healthRepository.delete(healthnum);
        return "redirect:/basic/healths";
    }

}
