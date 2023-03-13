package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.Subject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubjectRep extends JpaRepository<Subject,Long> {
    Subject getSubjectById(Long id);
}
