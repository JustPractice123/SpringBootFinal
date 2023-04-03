package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinishedTest {
    @Autowired
    UserService userService;
    @GetMapping(value = "/finishTest")
    public String finishTest(Model model){
        User user= userService.getCurrentUser();
        model.addAttribute("user",user);
        return "/HTML/finishTest";
    }
}
