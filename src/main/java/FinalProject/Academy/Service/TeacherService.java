package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.Teacher;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Repository.TeacherRep;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class TeacherService {
    @Autowired
    TeacherRep teacherRep;
    public Teacher addTeacher(User user){
        Teacher teacher=new Teacher();
        teacher.setUser(user);
        teacher.setStatus(false);
        teacherRep.save(teacher);
        return teacher;
    }
    public Teacher getByUserId(Long id){

        return teacherRep.findByUser_Id(id);
    }
    public void deleteTeacher(Long id){

        teacherRep.deleteById(id);
    }
    public void save(Teacher teacher){

        teacherRep.save(teacher);
    }
}
