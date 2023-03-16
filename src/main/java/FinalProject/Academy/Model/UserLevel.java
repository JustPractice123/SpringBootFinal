package FinalProject.Academy.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_level")
@Getter
@Setter
public class UserLevel extends BaseEntity{
    @Column(name = "score")
    private Integer score;
    @Column(name = "lvl")
    private  String lvl;
}
