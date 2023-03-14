package FinalProject.Academy.Controller.TestLevel;

import FinalProject.Academy.Model.AnswerForTest;
import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Model.TestTask;
import FinalProject.Academy.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    UserLvlService userLvlService;
    @Autowired
    UserService userService;
    @GetMapping(value = "/test/{id}")
    public String testG(@PathVariable(name = "id")Long id,
                        Model model){
        Subject subject=subjectService.getSubjectById(id);
        model.addAttribute("subject",subject);
        List<TestTask> tasks=taskService.getTasksBySubjectId(id);
        model.addAttribute("tasks",tasks);
        List<AnswerForTest> answers=answerService.getAnswers();
        model.addAttribute("answers",answers);
        return "/HTML/test";
    }
    @PostMapping(value = "/test")
    public String testP(@RequestParam(name = "answer[]") List<String> answers){
        for(String ans : answers){
            System.out.println(ans);
        }
        return "redirect:/testcompleted";
    }
}
