package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Login {
    @Autowired
    UserService userService;
    @GetMapping(value = "/login")
    public String login(){
        return "/HTML/login";
    }
}
