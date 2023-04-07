package FinalProject.Academy.dto;

import FinalProject.Academy.Model.Message;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ChatDTO {
    public List<MessageDTO> to_user;
    public List<MessageDTO> from_user;
}
