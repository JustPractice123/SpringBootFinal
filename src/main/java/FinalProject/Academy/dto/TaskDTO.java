package FinalProject.Academy.dto;

import FinalProject.Academy.Model.Subject;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskDTO {
    private Long id;
    private String question;
    private Integer level;
    public Subject subject;
}
