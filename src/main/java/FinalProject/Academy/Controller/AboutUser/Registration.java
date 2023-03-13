package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Registration {
    @Autowired
    UserService userService;
    @GetMapping(value = "/registration")
    public String reg(){
        return "/HTML/registration";
    }
    @PostMapping(value = "/registration")
    public String regP(@RequestParam(name = "email")String email,
                       @RequestParam(name = "password")String password,
                       @RequestParam(name = "fullName")String fullName,
                       @RequestParam(name = "gender")String gender,
                       @RequestParam(name = "age")Integer age,
                       @RequestParam(name = "address")String address){
        Boolean result=userService.addUser(email,password,fullName,gender,age,address);
        String redirect="";
        if (email.equals("") || password.equals("") || fullName.equals("") || gender.equals("") || age.equals("") || address.equals("")){
            redirect="redirect:/registration?insertUncorrectData";
        }else if (result.equals(Boolean.TRUE)){
            redirect="redirect:/login";
        }
        return redirect;
    }
}
