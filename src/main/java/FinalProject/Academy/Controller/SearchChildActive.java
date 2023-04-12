package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchChildActive {
    @Autowired
    private UserService userService;
    @PreAuthorize("hasAnyAuthority('ROLE_TEACHER')")
    @GetMapping(value = "/sstudents")
    public String search(@RequestParam(name = "student_name") String name,
                         @RequestParam(name = "level") String level,
                         @RequestParam(name = "subject") String subject,
                         Model model){
        List<User> students=userService.getStudentsByLevelAndFullName(level,name,subject);
        model.addAttribute("students", students);
        return "/HTML/searchstudents";
    }
}
