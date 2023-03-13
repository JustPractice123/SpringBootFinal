package FinalProject.Academy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "testTask")
@Getter
@Setter
public class TestTask extends BaseEntity{
    @Column(name = "question")
    private String question;
    @Column(name = "level")
    private Integer level;
    @ManyToOne
    public Subject subject;
}
