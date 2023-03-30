package FinalProject.Academy.Controller.AdminPanel;

import FinalProject.Academy.Model.Deleted;
import FinalProject.Academy.Service.DeletedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DeletedUser {
    @Autowired
    private DeletedService deletedService;
    @GetMapping(value = "/deleteduser")
    public String deletedUser(Model model){
        List<Deleted> deletedList=deletedService.getAllBannedUsers();
        model.addAttribute("users", deletedList);
        return "/HTML/deletedUser";
    }
    @PostMapping(value = "/deleteduser")
    public String deleted(@RequestParam(name = "email")String mail){
        deletedService.unBanned(mail);
        return "redirect:/deleteduser";
    }
}
