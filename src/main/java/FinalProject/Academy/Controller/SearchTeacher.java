package FinalProject.Academy.Controller;

import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchTeacher {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/searchteacher")
    public String searchTeacher(Model model){
        model.addAttribute("teachers",userService.getTeachers());
        return "/HTML/searchteacher";
    }
}
