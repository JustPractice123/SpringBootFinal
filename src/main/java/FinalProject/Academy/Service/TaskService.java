package FinalProject.Academy.Service;

import FinalProject.Academy.Model.TestTask;
import FinalProject.Academy.Repository.TaskRep;
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
    public List<TestTask> getTasksBySubjectId(Long id){
        List<TestTask> tasks=taskRep.findAllBySubject_id(id);
        return tasks;
    }
}
