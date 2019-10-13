package car.car1.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import lombok.extern.slf4j.Slf4j;
import car.car1.Information;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller


public class LoginController {
    @GetMapping("/login")
    public String showDesignForm(Model model) {
        model.addAttribute("Information", new Information());
        return "login";
    }

}
