package FinalProject.Academy.map;

import FinalProject.Academy.Model.TestTask;
import FinalProject.Academy.dto.TaskDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDTO toDTO(TestTask task);
    TestTask toEntity(TaskDTO taskDTO);
    List<TaskDTO> toDtoList(List<TestTask> tasks);
    List<TestTask> toEntityList(List<TaskDTO> taskDTOS);
}
