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
public class MyChildren {
    @Autowired
    private UserService userService;
    @PreAuthorize("hasAnyAuthority('ROLE_TEACHER')")
    @GetMapping(value = "/myChildren")
    public String getChildren(Model model){
        User user= userService.getUserById(userService.getCurrentUser().getId());
        List<Children> list=user.getChildren();
        List<Children> children=new ArrayList<>();
        for (Children c:list){
            if (c.isStatus()){
                children.add(c);
            }
        }
        model.addAttribute("children",children);
        return "/HTML/myChildren";
    }
}
