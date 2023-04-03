package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Profile {
    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model){
        User user= userService.getUserById(userService.getCurrentUser().getId());
        model.addAttribute("user",user);
        return "/HTML/profile";
    }
    @GetMapping(value = "/profile/{id}")
    public String profile(@PathVariable(name = "id")Long id,
                          Model model){
        User user= userService.getUserById(id);
        model.addAttribute("user",user);
        return "/HTML/profile";
    }
}
