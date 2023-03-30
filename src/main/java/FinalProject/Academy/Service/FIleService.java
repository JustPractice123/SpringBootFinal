package FinalProject.Academy.Service;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Getter
@Setter
public class FIleService {
    @Autowired
    private UserService userService;
    public boolean uploadAvatar(MultipartFile file){
        if (file.getContentType().equals("image/jpeg") || file.getContentType().equals("image/png")){
            try {
                byte bytes[]=file.getBytes();
                String fileName= DigestUtils.sha1Hex(userService.getCurrentUser().getId()+"");
                String filePath="build/resources/main/static/UsersAvatars/" +fileName+ ".jpg";
                Path path= Paths.get(filePath);
                Files.write(path,bytes);
                return true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
