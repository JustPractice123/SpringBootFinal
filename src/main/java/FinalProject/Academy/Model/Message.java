package FinalProject.Academy.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "message")
@Getter
@Setter
public class Message extends BaseEntity{
    @Column(name = "message")
    public String message;
    @OneToOne
    public User touser;
    @OneToOne
    public User fromuser;
}
