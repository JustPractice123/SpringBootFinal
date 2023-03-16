package FinalProject.Academy.dto;

import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Model.TestTask;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AnswerDTO {
    private Long id;
    private String content;
    private Boolean status;
    public TestTask task;
    public Subject subject;
}
