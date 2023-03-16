package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchTeacherActive {
    @Autowired
    private UserService userService;
    @GetMapping(value = "steacher")
    public String search(@RequestParam(name = "teacher_name")String name,
                         Model model){
        List<User> teachers=userService.getTeachersByName(name);
        model.addAttribute("teachers", teachers);
        return "/HTML/searchteacheractive";
    }
}
