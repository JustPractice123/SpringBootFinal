package FinalProject.Academy.Service;

import FinalProject.Academy.Model.AnswerForTest;
import FinalProject.Academy.Model.UserAnswerForTest;
import FinalProject.Academy.Repository.UserAnswerRep;
import FinalProject.Academy.dto.AnswerDTO;
import FinalProject.Academy.map.AnswerMapper;
import FinalProject.Academy.map.SubjectMapper;
import FinalProject.Academy.map.TaskMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void addAnswer(AnswerDTO answerDTO){
        AnswerForTest answer=answerMapper.toEntity(answerService.getAnswerById(answerDTO.getId()));
        UserAnswerForTest userAnswer=userAnswerRep.findByUser_IdAndSubject_IdAndTask_Id(
                userService.getCurrentUser().getId(),answer.subject.getId(),answer.task.getId());
        UserAnswerForTest userAnswerForTest=new UserAnswerForTest();
        if (userAnswer!=null){
            userAnswerForTest.setId(userAnswer.getId());
        }
        userAnswerForTest.setUser(userService.getCurrentUser());
        userAnswerForTest.setSubject(answer.getSubject());
        userAnswerForTest.setTask(answer.getTask());
        userAnswerForTest.setAnswer(answer);
        userAnswerRep.save(userAnswerForTest);
    }
    public List<UserAnswerForTest> getAnswersByUser_id(Long user_id,Long subject_id){
        List<UserAnswerForTest> list=userAnswerRep.findAllByUser_IdAndSubject_Id(user_id,subject_id);
        return list;
    }
}
