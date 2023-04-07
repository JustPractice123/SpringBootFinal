package FinalProject.Academy.Repository;

import FinalProject.Academy.Model.Children;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ChildrenRep extends JpaRepository<Children,Long> {
    Children findByUser_Id(Long id);
}
