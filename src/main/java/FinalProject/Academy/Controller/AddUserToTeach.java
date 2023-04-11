package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.Teacher;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.ChildrenService;
import FinalProject.Academy.Service.TeacherService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddUserToTeach {
    @Autowired
    private UserService userService;
    @Autowired
    private ChildrenService childrenService;
    @Autowired
    private TeacherService teacherService;
    @PostMapping(value = "/addUserToTeach")
    public String addUser(@RequestParam(name = "id")Long id_user){
        User curUser= userService.getCurrentUser();
        for (Role r:curUser.role){
            if (r.getId().equals(2l)){
                User user=userService.getUserById(id_user);
                Teacher teacher=teacherService.addTeacher(curUser);
                user.getTeacher().add(teacher);
                userService.save(user);
            }else if (r.getId().equals(3l)){
                User user=userService.getUserById(id_user);
                Children children=childrenService.addChildren(curUser);
                user.getChildren().add(children);
                userService.save(user);
            }
        }
        return "redirect:/profile/"+id_user;
    }
}
