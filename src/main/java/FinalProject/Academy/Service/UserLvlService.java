package FinalProject.Academy.Service;

import FinalProject.Academy.Model.UserLevel;
import FinalProject.Academy.Repository.UserLvlRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLvlService {
    @Autowired
    UserLvlRep userLvlRep;
    @Autowired
    UserService userService;
    public void addLevel(Integer result){
        UserLevel userLevel=new UserLevel();
        userLevel.setScore(result);
        userLevel.setUser(userService.getCurrentUser());
        userLvlRep.save(userLevel);
    }
}
