package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRep extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}
