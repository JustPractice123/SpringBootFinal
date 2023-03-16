package FinalProject.Academy.Service;

import FinalProject.Academy.Model.AnswerForTest;
import FinalProject.Academy.Repository.AnswerRep;
import FinalProject.Academy.dto.AnswerDTO;
import FinalProject.Academy.map.AnswerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    AnswerRep answerRep;
    @Autowired
    AnswerMapper answerMapper;
    public List<AnswerDTO> getAnswers(){
        List<AnswerDTO> answerDTOS=answerMapper.toDtoList(answerRep.findAll());
        return answerDTOS;
    }
    public List<AnswerDTO> getAnswersBySubjectId(Long id){
        List<AnswerDTO> answerDTOS=answerMapper.toDtoList(answerRep.getAnswerForTestBySubject_Id(id));
        return answerDTOS;
    }
    public List<AnswerDTO> getAnswersByTaskId(Long id){
        List<AnswerDTO> answerDTOS=answerMapper.toDtoList(answerRep.getAnswerForTestByTaskId(id));
        return answerDTOS;
    }
}
