package FinalProject.Academy.Controller;

import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchChild {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/searchstudents")
    public String searchTeacher(Model model){
        model.addAttribute("students",userService.getStudents());
        return "/HTML/searchstudents";
    }
}
