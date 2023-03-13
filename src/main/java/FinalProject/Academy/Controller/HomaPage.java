package FinalProject.Academy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomaPage {
    @GetMapping(value = "/")
    public String homePage(){
        return "/HTML/HomePage";
    }
}
