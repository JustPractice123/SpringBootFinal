package FinalProject.Academy.dto;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private Long id;
    private String message;
    private User teacher;
    private Children children;
}
