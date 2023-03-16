package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.AnswerForTest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface AnswerRep extends JpaRepository<AnswerForTest,Long> {
    List<AnswerForTest> getAnswerForTestBySubject_Id(Long id);
    List<AnswerForTest> getAnswerForTestByTaskId(Long id);
}
