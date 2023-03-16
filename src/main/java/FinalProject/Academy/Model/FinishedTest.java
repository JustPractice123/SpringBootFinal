package FinalProject.Academy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "finish_test")
@Getter
@Setter
public class FinishedTest extends BaseEntity{
    @Column(name = "answer")
    private Boolean answer;
    @ManyToOne
    public Subject subject;
    @ManyToOne
    public User user;
}
