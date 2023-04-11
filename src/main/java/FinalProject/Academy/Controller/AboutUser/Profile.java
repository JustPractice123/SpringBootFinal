package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.Teacher;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.ChildrenService;
import FinalProject.Academy.Service.TeacherService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Profile {
    @Autowired
    private UserService userService;
    @Autowired
    private ChildrenService childrenService;
    @Autowired
    private TeacherService teacherService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profile(Model model){
        User user= userService.getUserById(userService.getCurrentUser().getId());
        model.addAttribute("user",user);
        return "/HTML/profile";
    }
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile/{id}")
    public String profile(@PathVariable(name = "id")Long id,
                          Model model){
        User user= userService.getUserById(id);
        List<Children> list=user.getChildren();
        List<Teacher> listT=user.getTeacher();
        User user1=userService.getCurrentUser();
        boolean x=true;
        for (Role r:user1.role){
            if (r.getId().equals(2l)){
                for (Teacher u:listT){
                    if (u.equals(teacherService.getByUserId(user1.getId()))){
                        x=false;
                    }
                }
                model.addAttribute("user",user);
                model.addAttribute("boolean",x);
            }else if (r.getId().equals(3l)){
                for (Children u:list){
                    if (u.equals(childrenService.getByUserId(user1.getId()))){
                        x=false;
                    }
                }
                model.addAttribute("user",user);
                model.addAttribute("boolean",x);
            }
        }
        return "/HTML/profile";
    }
}
