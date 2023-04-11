package FinalProject.Academy.map;

import FinalProject.Academy.dto.ChatDTO;
import FinalProject.Academy.dto.MessageDTO;
import FinalProject.Academy.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    ChatDTO toDTO(List<MessageDTO> allMessages, UserDTO user);
}
