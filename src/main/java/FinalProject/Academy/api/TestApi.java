package FinalProject.Academy.api;

import FinalProject.Academy.Service.AnswerService;
import FinalProject.Academy.Service.SubjectService;
import FinalProject.Academy.Service.TaskService;
import FinalProject.Academy.Service.UserAnswerService;
import FinalProject.Academy.dto.AnswerDTO;
import FinalProject.Academy.dto.SubjectDTO;
import FinalProject.Academy.dto.TaskDTO;
import FinalProject.Academy.dto.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/test/{sub-id}")
public class TestApi {
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    UserAnswerService userAnswerService;
    @GetMapping
    public TestDTO test(@PathVariable(name = "sub-id")Long sub_id) {
        SubjectDTO subjectDTO=subjectService.getSubjectById(sub_id);
        List<TaskDTO> taskDTOs=taskService.getTasksBySubjectId(sub_id);
        List<AnswerDTO> answerDTOS=answerService.getAnswersBySubjectId(subjectDTO.getId());
        TestDTO testDTO= TestDTO.builder()
                .subject(subjectDTO)
                .tasks(taskDTOs)
                .answers(answerDTOS)
                .build();
        return testDTO;
    }
    @PostMapping
    public void testPost(@RequestParam(name = "answer")Long answer_id,
                            @RequestParam(name = "task")Long task_id,
                            @RequestParam(name = "subject")Long subject_id){
        userAnswerService.addAnswer(subject_id,task_id,answer_id);
    }
}
