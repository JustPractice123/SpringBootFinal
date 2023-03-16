package FinalProject.Academy.Controller.TestLevel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCompleted {
    @GetMapping(value = "/testcompleted")
    public String testcompleted(){
        return "/HTML/testcompleted";
    }
}
