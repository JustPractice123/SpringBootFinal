package FinalProject.Academy.Controller.TestLevel;

import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class test {
    @Autowired
    SubjectService subjectService;
    @GetMapping(value = "/test/{id}")
    public String testG(@PathVariable(name = "id")Long id,
                        Model model){
        Subject subject=subjectService.getSubjectById(id);
        model.addAttribute("subject",subject);
        return "/HTML/test";
    }
}
