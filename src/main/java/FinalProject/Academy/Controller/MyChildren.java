package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MyChildren {
    @Autowired
    private UserService userService;
    @GetMapping(value = "/myChildren")
    public String getChildren(Model model){
        List<Children> list=userService.getCurrentUser().getChildren();
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
