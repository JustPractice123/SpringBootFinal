package FinalProject.Academy.Controller.TestLevel;

import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.SubjectService;
import FinalProject.Academy.Service.UserService;
import FinalProject.Academy.map.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TestCompleted {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private UserService userService;
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/testcompleted/{id}")
    public String testcompleted(@PathVariable(name = "id")Long id,
                                Model model) {
        Subject subject=subjectMapper.toEntity(subjectService.getSubjectById(id));
        User user= userService.getUserById(userService.getCurrentUser().getId());
        user.setSubject(subject);
        userService.save(user);
        model.addAttribute("user",user);
        model.addAttribute("subject", subject);
        return "/HTML/testcompleted";
    }
}
