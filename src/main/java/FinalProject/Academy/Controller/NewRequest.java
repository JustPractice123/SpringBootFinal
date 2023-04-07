package FinalProject.Academy.Controller;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Service.ChildrenService;
import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NewRequest {
    @Autowired
    private UserService userService;
    @Autowired
    private ChildrenService childrenService;
    @GetMapping(value = "/newRequests")
    public String getNews(Model model){
        List<Children> list=userService.getCurrentUser().getChildren();
        List<Children> children=new ArrayList<>();
        for (Children c:list){
            if (!c.isStatus()){
                children.add(c);
            }
        }
        model.addAttribute("children",children);
        return "/HTML/newRequests";
    }
    @PostMapping(value = "/addRequest")
    public String add(@RequestParam(name = "id_a")Long id){
        Children children=childrenService.getByUserId(id);
        children.setStatus(true);
        childrenService.save(children);
        return "redirect:/newRequests";
    }
    @PostMapping(value = "/deleteRequest")
    public String delete(@RequestParam(name = "id_d")Long id){
        Children children=childrenService.getByUserId(id);
        userService.getCurrentUser().getChildren().remove(children);
        userService.save(userService.getCurrentUser());
        childrenService.deleteChildren(children.getId());
        return "redirect:/newRequests";
    }
}
