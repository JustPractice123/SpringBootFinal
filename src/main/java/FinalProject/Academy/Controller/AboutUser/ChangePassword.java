package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePassword {
    @Autowired
    UserService userService;
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/changepassword")
    public String changeProfile(Model model){
        User user= userService.getCurrentUser();
        model.addAttribute("user", userService.getUserById(user.getId()));
        return "/HTML/changepassword";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/changepassword")
    public String changeProfileP(@RequestParam(name = "password")String password,
                                 @RequestParam(name = "id")Long id,
                                 @RequestParam(name = "repeat_password")String repeat_password){
        if (!(password.equals(repeat_password))){
            return "redirect:/changepassword?passworderror";
        }
        userService.changePassword(password,id);
        return "redirect:/profile";
    }
}
