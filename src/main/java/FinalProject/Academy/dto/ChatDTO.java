package FinalProject.Academy.dto;

import FinalProject.Academy.Model.Message;
import FinalProject.Academy.Model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ChatDTO {
    public List<Message> allMessage;
    public User user;
}
