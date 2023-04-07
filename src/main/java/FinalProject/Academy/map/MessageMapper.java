package FinalProject.Academy.map;

import FinalProject.Academy.Model.Message;
import FinalProject.Academy.dto.MessageDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDTO toDTO(Message message);
    Message toEntity(MessageDTO messageDTO);
    List<MessageDTO> toDTOlist(List<Message> messages);
    List<Message> toEntityList(List<MessageDTO> messageDTOS);
}
