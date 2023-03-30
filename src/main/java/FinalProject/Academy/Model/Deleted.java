package FinalProject.Academy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deleted_users")
@Getter
@Setter
public class Deleted extends BaseEntity{
    @Column(name = "email")
    private String email;
}
