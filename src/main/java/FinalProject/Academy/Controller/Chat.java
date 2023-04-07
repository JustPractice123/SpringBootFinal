package FinalProject.Academy.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Chat {
    @GetMapping(value = "/chat")
    public String chat(){

        return "/HTML/chat";
    }
}
