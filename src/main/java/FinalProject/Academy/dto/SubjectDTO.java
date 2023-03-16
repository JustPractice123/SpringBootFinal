package FinalProject.Academy.dto;

import FinalProject.Academy.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    private Long id;
    private String name;
    public User user;
}
