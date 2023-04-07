package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.Message;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface MessageRep extends JpaRepository<Message,Long> {
    List<Message> findAllByFromuser_id(Long id);
    List<Message> findAllByTouser_id(Long id);
}
