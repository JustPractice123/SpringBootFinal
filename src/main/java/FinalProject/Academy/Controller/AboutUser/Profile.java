package FinalProject.Academy.Controller.AboutUser;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Profile {
    @GetMapping(value = "/profile")
    public String profile(){
        return "/HTML/profile";
    }
}
