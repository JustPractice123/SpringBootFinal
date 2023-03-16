package FinalProject.Academy.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TestDTO {
    private SubjectDTO subject;
    private List<TaskDTO> tasks;
    private List<AnswerDTO> answers;
}
