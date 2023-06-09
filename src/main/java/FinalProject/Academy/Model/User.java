package FinalProject.Academy.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.control.MappingControl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "score")
    private Integer score;
    @Column(name = "picture")
    private String picture;
    @ManyToMany(fetch = FetchType.EAGER)
    public List<Role> role;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Children> children;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Teacher> teacher;
    @ManyToOne
    private UserLevel userLevel;
    @ManyToOne
    private Subject subject;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
