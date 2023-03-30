package FinalProject.Academy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_answers")
@Getter
@Setter
public class UserAnswerForTest extends BaseEntity{
    @OneToOne
    private User user;
    @OneToOne
    private TestTask task;
    @OneToOne
    private AnswerForTest answer;
    @OneToOne
    private Subject subject;
}
