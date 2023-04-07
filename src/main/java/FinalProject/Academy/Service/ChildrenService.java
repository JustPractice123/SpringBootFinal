package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Children;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Repository.ChildrenRep;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class ChildrenService {
    @Autowired
    ChildrenRep childrenRep;
    public Children addChildren(User user){
        Children children=new Children();
        children.setUser(user);
        children.setStatus(false);
        childrenRep.save(children);
        return children;
    }
    public Children getByUserId(Long id){
        return childrenRep.findByUser_Id(id);
    }
    public void deleteChildren(Long id){
        childrenRep.deleteById(id);
    }
    public void save(Children children){
        childrenRep.save(children);
    }
    public Children getChildrenById(Long id){
        return childrenRep.findById(id).orElseThrow();
    }
}
