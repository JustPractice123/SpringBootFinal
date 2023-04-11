package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.ChildrenService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class Chat {
    @Autowired
    UserService userService;
    @Autowired
    ChildrenService childrenService;
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/chat/{id}")
    public String chat(Model model,
                       @PathVariable(name = "id")Long id){
        User curUs=userService.getCurrentUser();
        List<Role> roles=curUs.getRole();
        User user=new User();
        for (Role r:roles){
            if (r.getId().equals(2l)){
                user=childrenService.getChildrenById(id).getUser();
                break;
            }else {
                user=userService.getUserById(id);
            }
        }

        model.addAttribute("user", user);
        return "/HTML/chat";
    }
}
