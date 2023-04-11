package FinalProject.Academy.Controller.AdminPanel;

import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.DeletedService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeleteAcc {
    @Autowired
    private UserService userService;
    @Autowired
    private DeletedService deletedService;
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/deleteacc")
    public String deleteacc(Model model){
        List<User> allUsers=userService.getAllUsers();
        model.addAttribute("allUsers",allUsers);
        return "HTML/deleteacc";
    }
    @PostMapping(value = "/deleteacc")
    public String deleteaccp(@RequestParam(name = "userid")Long id){
        User user=userService.getUserById(id);
        deletedService.addToBanList(user.getEmail());
        userService.deleteUser(id);
        return "redirect:/deleteacc";
    }
}
