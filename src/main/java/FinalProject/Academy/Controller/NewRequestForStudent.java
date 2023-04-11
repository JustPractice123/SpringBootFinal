package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.Teacher;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.ChildrenService;
import FinalProject.Academy.Service.TeacherService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewRequestForStudent {
    @Autowired
    private UserService userService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ChildrenService childrenService;
    @GetMapping(value = "/newRequestsForStud")
    public String getNewsForStudents(Model model){
        User user=userService.getUserById(userService.getCurrentUser().getId());
        List<Teacher> list=user.getTeacher();
        List<Teacher> teachers=new ArrayList<>();
        for (Teacher t:list){
            if (!t.isStatus()){
                teachers.add(t);
            }
        }
        model.addAttribute("teachers",teachers);
        return "/HTML/newRequestsForStud";
    }
    @PostMapping(value = "/addRequestForStud")
    public String addTeacher(@RequestParam(name = "id_a")Long id){
        User user=userService.getUserById(id);
        Children children=childrenService.addChildren(userService.getUserById(userService.getCurrentUser().getId()));
        user.getChildren().add(children);
        userService.save(user);
        children.setStatus(true);
        childrenService.save(children);
        Teacher teacher=teacherService.getByUserId(id);
        userService.getUserById(userService.getCurrentUser().getId()).getTeacher().remove(teacher);
        userService.save(userService.getUserById(userService.getCurrentUser().getId()));
        teacherService.deleteTeacher(teacher.getId());
        return "redirect:/newRequestsForStud";
    }
    @PostMapping(value = "/deleteRequestForStud")
    public String deleteTeacher(@RequestParam(name = "id_d")Long id){
        Teacher teacher=teacherService.getByUserId(id);
        userService.getUserById(userService.getCurrentUser().getId()).getTeacher().remove(teacher);
        userService.save(userService.getUserById(userService.getCurrentUser().getId()));
        teacherService.deleteTeacher(teacher.getId());
        return "redirect:/newRequestsForStud";
    }
}
