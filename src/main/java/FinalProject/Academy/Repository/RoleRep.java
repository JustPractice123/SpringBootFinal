package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RoleRep extends JpaRepository<Role,Long> {
}
