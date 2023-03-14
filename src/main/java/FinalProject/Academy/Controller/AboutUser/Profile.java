package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Profile {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/profile")
    public String profile(Model model){
        User user= userService.getUserById(userService.getCurrentUser().getId());
        model.addAttribute("user",user);
        return "/HTML/profile";
    }
}
