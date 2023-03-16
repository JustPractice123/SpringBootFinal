package FinalProject.Academy.Service;

import FinalProject.Academy.Model.TestTask;
import FinalProject.Academy.Repository.TaskRep;
import FinalProject.Academy.dto.TaskDTO;
import FinalProject.Academy.map.TaskMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class TaskService {
    @Autowired
    TaskRep taskRep;
    @Autowired
    TaskMapper taskMapper;
    public List<TaskDTO> getTasksBySubjectId(Long id){
        List<TestTask> tasks=taskRep.findAllBySubject_id(id);
        List<TaskDTO> taskDTOS=taskMapper.toDtoList(tasks);
        return taskDTOS;
    }
    public TaskDTO getTaskById(Long id){
        TestTask task=taskRep.findById(id).orElseThrow();
        return taskMapper.toDTO(task);
    }
}
