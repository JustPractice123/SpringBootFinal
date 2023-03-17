package FinalProject.Academy.Controller.AdminPanel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanel {
    @GetMapping(value = "/adminpanel")
    public String adminPanel(){
        return "/HTML/adminpanel";
    }
}
