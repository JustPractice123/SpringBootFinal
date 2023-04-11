package FinalProject.Academy.Controller.AboutUser;

import FinalProject.Academy.Service.FIleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Uploadphoto {
    @Autowired
    private FIleService fileUploadService;
    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/uploadphoto")
    public String upload(@RequestParam(name = "user_avatar")MultipartFile file){
        fileUploadService.uploadAvatar(file);
        return "redirect:/profile";
    }
}
