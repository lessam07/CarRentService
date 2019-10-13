package car.car1.web;

import car.car1.Information;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class updateUserController {
    @GetMapping("/update-user")
    public String menu(Model model) {
        model.addAttribute("info", new Information());
        return "update-user";
    }
}
