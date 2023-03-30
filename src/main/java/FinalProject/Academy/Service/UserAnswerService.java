package FinalProject.Academy.Service;

import FinalProject.Academy.Model.UserAnswerForTest;
import FinalProject.Academy.Repository.UserAnswerRep;
import FinalProject.Academy.map.AnswerMapper;
import FinalProject.Academy.map.SubjectMapper;
import FinalProject.Academy.map.TaskMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserAnswerService {
    @Autowired
    UserAnswerRep userAnswerRep;
    @Autowired
    UserService userService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    TaskService taskService;
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    AnswerService answerService;
    @Autowired
    AnswerMapper answerMapper;
    public void addAnswer(Long subjectID,Long taskID,Long answerID){
        UserAnswerForTest answer=new UserAnswerForTest();
        answer.setUser(userService.getCurrentUser());
        answer.setSubject(subjectMapper.toEntity(subjectService.getSubjectById(subjectID)));
        answer.setTask(taskMapper.toEntity(taskService.getTaskById(taskID)));
        answer.setAnswer(answerMapper.toEntity(answerService.getAnswerById(answerID)));
        userAnswerRep.save(answer);
    }
}
