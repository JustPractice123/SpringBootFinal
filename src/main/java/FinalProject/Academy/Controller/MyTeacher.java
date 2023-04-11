package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyTeacher {
    @Autowired
    private UserService userService;
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping(value = "/myTeacher")
    public String getMyTeacher(Model model){
        User user=userService.getCurrentUser();
        List<User> users=userService.getTeachers();
        List<User> teachers=new ArrayList<>();
        for(User u:users){
            for(Children c:u.getChildren()){
                if (c.getUser().getId()==user.getId()){
                    teachers.add(u);
                }
            }
        }
        model.addAttribute("teachers",teachers);
        return "/HTML/myTeacher";
    }
}
