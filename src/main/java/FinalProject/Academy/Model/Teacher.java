package FinalProject.Academy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "teacher")
@Getter
@Setter
public class Teacher extends BaseEntity{
    @OneToOne
    User user;
    @Column(name = "status")
    boolean status;
}
