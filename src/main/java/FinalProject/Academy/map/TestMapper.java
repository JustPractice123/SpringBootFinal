package FinalProject.Academy.map;

import FinalProject.Academy.dto.AnswerDTO;
import FinalProject.Academy.dto.SubjectDTO;
import FinalProject.Academy.dto.TaskDTO;
import FinalProject.Academy.dto.TestDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TestMapper {
    TestDTO toDTO(SubjectDTO subjectDTO, List<TaskDTO> taskDTOS, List<AnswerDTO> answerDTOS);
}
