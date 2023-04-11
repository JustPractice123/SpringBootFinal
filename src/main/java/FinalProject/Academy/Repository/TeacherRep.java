package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TeacherRep extends JpaRepository<Teacher, Long> {
    Teacher findByUser_Id(Long id);
}
