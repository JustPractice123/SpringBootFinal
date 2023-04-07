package FinalProject.Academy.map;

import FinalProject.Academy.dto.ChatDTO;
import FinalProject.Academy.dto.MessageDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    ChatDTO toDTO(List<MessageDTO> to_user, List<MessageDTO> from_user);
}
