package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Repository.RoleRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRep roleRep;
    public Role getRoleByID(Long id){
        Role role1=roleRep.findRoleById(id);
        return role1;
    }
}
