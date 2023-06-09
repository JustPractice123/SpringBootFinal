package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface UserRep extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
    User findUserById(Long id);
    List<User> findAllByRole_id(Long id);
    User findUserByRole_id(Long id);
    List<User> findAllByUserLevel_LvlAndFullNameContainingAndRole_idAndSubject_Name(String level,String fullName, Long id, String subject);
    List<User> findAllByFullNameContainingAndRole_id(String fullName,Long id);
    List<User> findAllByUserLevelContainingAndRole_id(String lvl,Long id);
}
