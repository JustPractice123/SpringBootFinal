package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.UserAnswerForTest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserAnswerRep extends JpaRepository<UserAnswerForTest,Long> {
    UserAnswerForTest findByUser_IdAndSubject_IdAndTask_Id(Long user_id,Long subject_id,
                                                                       Long task_id);
    List<UserAnswerForTest> findAllByUser_IdAndSubject_Id(Long user_id, Long subject_id);
}
