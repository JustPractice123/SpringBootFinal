package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.ChildrenService;
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
    @PostMapping(value = "/addUserToTeach")
    public String addUser(@RequestParam(name = "id")Long id_user){
        User user=userService.getUserById(id_user);
        Children children=childrenService.addChildren(userService.getCurrentUser());
        user.getChildren().add(children);
        userService.save(user);
        return "redirect:/profile/"+id_user;
    }
}
