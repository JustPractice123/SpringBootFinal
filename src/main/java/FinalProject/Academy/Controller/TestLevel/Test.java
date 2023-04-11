package FinalProject.Academy.Controller.TestLevel;

import FinalProject.Academy.Model.AnswerForTest;
import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Model.TestTask;
import FinalProject.Academy.Service.*;
import FinalProject.Academy.dto.AnswerDTO;
import FinalProject.Academy.dto.SubjectDTO;
import FinalProject.Academy.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Test {
    @Autowired
    SubjectService subjectService;
    @Autowired
    TaskService taskService;
    @Autowired
    AnswerService answerService;
    @Autowired
    UserService userService;
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/test/{id}")
    public String testG(@PathVariable(name = "id")Long id,
                        Model model){
        SubjectDTO subjectDTO=subjectService.getSubjectById(id);
        model.addAttribute("subject",subjectDTO);
        return "/HTML/test";
    }
}
