package FinalProject.Academy.Controller.TestLevel;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCompleted {
    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/testcompleted")
    public String testcompleted(){
        return "/HTML/testcompleted";
    }
}
