package FinalProject.Academy.map;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.dto.UserDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
    List<UserDTO> toDtoList(List<User> list);
    List<User> toEntityList(List<UserDTO> list);
}
