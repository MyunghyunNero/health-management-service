package health.health.management.web.basic;


import health.health.management.domain.Health;
import health.health.management.domain.healthRepository;
import health.health.management.domain.type.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "redirect:";

    }

}
