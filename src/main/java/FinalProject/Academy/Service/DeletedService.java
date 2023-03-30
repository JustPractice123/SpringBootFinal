package FinalProject.Academy.Service;

import FinalProject.Academy.Controller.AdminPanel.DeletedUser;
import FinalProject.Academy.Model.Deleted;
import FinalProject.Academy.Repository.DeletedRep;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class DeletedService {
    @Autowired
    private DeletedRep deletedRep;
    public void unBanned(String email){
        Deleted deleted=deletedRep.findByEmail(email);
        deletedRep.delete(deleted);
    }
    public void addToBanList(String email){
        Deleted deleted=new Deleted();
        deleted.setEmail(email);
        deletedRep.save(deleted);
    }
    public Deleted getBannedUser(String email){
        Deleted deleted=deletedRep.findByEmail(email);
        return deleted;
    }
    public List<Deleted> getAllBannedUsers(){
        List<Deleted> deletedList=deletedRep.findAll();
        return deletedList;
    }
}
