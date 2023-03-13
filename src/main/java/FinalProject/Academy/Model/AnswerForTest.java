package FinalProject.Academy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "answer")
@Getter
@Setter
public class AnswerForTest extends BaseEntity{
    @Column(name = "content")
    private String content;
    @Column(name = "status")
    private Boolean status;
    @ManyToOne
    public TestTask task;
}
