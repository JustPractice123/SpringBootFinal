package FinalProject.Academy.Controller.TestLevel;

import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChoseSubject {
    @Autowired
    SubjectService subjectService;
    @GetMapping(value = "/choseSubject")
    public String choseSubject(Model model){
        List<Subject> subjects=subjectService.getSubjects();
        model.addAttribute("subject", subjects);
        return "/HTML/choseSubject";
    }
}
