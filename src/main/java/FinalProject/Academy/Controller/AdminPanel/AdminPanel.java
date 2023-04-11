package FinalProject.Academy.Controller.AdminPanel;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanel {
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/adminpanel")
    public String adminPanel(){
        return "/HTML/adminpanel";
    }
}
