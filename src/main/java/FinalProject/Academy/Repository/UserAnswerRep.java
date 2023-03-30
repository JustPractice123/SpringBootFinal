package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.UserAnswerForTest;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserAnswerRep extends JpaRepository<UserAnswerForTest,Long> {
}
