package FinalProject.Academy.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Table(name = "role")
@Setter
@Getter
public class Role extends BaseEntity implements GrantedAuthority {
    public String role;
    public String name;

    @Override
    public String getAuthority() {
        return role;
    }
}
