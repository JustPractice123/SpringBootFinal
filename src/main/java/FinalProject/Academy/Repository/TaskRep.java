package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.TestTask;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TaskRep extends JpaRepository<TestTask,Long> {
    List<TestTask> findAllBySubject_id(Long id);
}
