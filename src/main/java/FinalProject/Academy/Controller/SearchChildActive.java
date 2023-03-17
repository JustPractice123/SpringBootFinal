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
public class SearchChildActive {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/sstudents")
    public String search(@RequestParam(name = "student_name") String name,
                         @RequestParam(name = "level") String level,
                         Model model){
        if (name==null){
            List<User> users=userService.getStudents();
            model.addAttribute("students",users);
            return "/HTML/searchstudents";
        }else if (level==null){
            List<User> studentswithoutlevel=userService.getStudentsByFullName(name);
            model.addAttribute("students",studentswithoutlevel);
            return "/HTML/searchstudents";
        }else if (level!=null && name!=null){
        List<User> students=userService.getStudentsByLevelAndFullName(level,name);
        model.addAttribute("students", students);
        return "/HTML/searchstudents";
        }
        return "/HTML/delaultErrorPage";
    }
}
