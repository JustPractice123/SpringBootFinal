package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangeProfile {
    @Autowired
    UserService userService;
    @GetMapping(value = "/changeprofile")
    public String changeProfile(){
        return "/HTML/changeprofile";
    }
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
