package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.Deleted;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DeletedRep extends JpaRepository<Deleted, Long> {
    Deleted findByEmail(String email);
}
