package FinalProject.Academy.Controller.AdminPanel;

import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Repository.SubjectRep;
import FinalProject.Academy.Repository.UserLvlRep;
import FinalProject.Academy.Service.RoleService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ChangeSubjectAndLvlForTeacher {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLvlRep userLvlRep;
    @Autowired
    private SubjectRep subjectRep;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/changeSubjectAndLvlForTeacher")
    public String changeroleuser(Model model){
        List<User> teachers=userService.getTeachers();
        model.addAttribute("teachers",teachers);
        return "/HTML/changeSubjectAndLvlForTeacher";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/changeSubjectAndLvlForTeacher")
    public String changeroleuserp(@RequestParam(name = "userid")Long id,
                                  @RequestParam(name = "subject")Long subject,
                                  @RequestParam(name = "level")Long level){
        User user=userService.getUserById(id);
        user.setUserLevel(userLvlRep.findById(level).orElseThrow());
        user.setSubject(subjectRep.getSubjectById(subject));
        userService.save(user);
        return "redirect:/changeSubjectAndLvlForTeacher";
    }
}
