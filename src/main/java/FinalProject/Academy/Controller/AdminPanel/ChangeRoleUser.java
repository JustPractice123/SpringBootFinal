package FinalProject.Academy.Controller.AdminPanel;

import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.RoleService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChangeRoleUser {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/changeroleuser")
    public String changeroleuser(Model model){
        List<User> allUsers=userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "/HTML/changerole";
    }
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @PostMapping(value = "/changeroleuser")
    public String changeroleuserp(@RequestParam(name = "userid")Long id,
                                  @RequestParam(name = "roleid")Long role){
        User user=userService.getUserById(id);
        Role newrole= roleService.getRoleByID(role);
        user.getRole().remove(0);
        user.getRole().add(newrole);
        userService.save(user);
        return "redirect:/changeroleuser";
    }
}
