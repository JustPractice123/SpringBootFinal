package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeProfile {
    @Autowired
    UserService userService;
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/changeprofile")
    public String changeProfile(Model model){
        User user= userService.getCurrentUser();
        model.addAttribute("user",userService.getUserById(user.getId()));
        return "/HTML/changeprofile";
    }
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/changeprofile")
    public String changeProfileP(@RequestParam(name = "id")Long id,
                                 @RequestParam(name = "fullName")String fullName,
                                 @RequestParam(name = "address")String address,
                                 @RequestParam(name = "age")Integer age,
                                 @RequestParam(name = "gender")String gender){
        userService.changeUser(id,fullName,gender,age,address);
        return "redirect:/profile";
    }
}
