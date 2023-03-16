package FinalProject.Academy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUs {
    @GetMapping(value = "/aboutus")
    public String aboutus(){
        return "/HTML/aboutUs";
    }
}
