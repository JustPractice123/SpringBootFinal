package FinalProject.Academy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
@Setter
@Getter
public class Role extends BaseEntity implements GrantedAuthority {
    private String role;
    private String name;

    @Override
    public String getAuthority() {
        return role;
    }
}
