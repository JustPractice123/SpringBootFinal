package FinalProject.Academy.dto;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.Subject;
import FinalProject.Academy.Model.UserLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class UserDTO {
    private String email;
    private String password;
    private String fullName;
    private Integer age;
    private String gender;
    private String address;
    private Integer score;
    private String picture;
    public List<Role> role;
    private List<Children> children;
    private UserLevel userLevel;
    private Subject subject;

}
