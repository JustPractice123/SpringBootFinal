package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Repository.RoleRep;
import FinalProject.Academy.Repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

public class UserService implements UserDetailsService {
    @Autowired
    UserRep userRep;
    @Autowired
    RoleRep roleRep;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRep.findUserByEmail(username);
        if (user==null)throw new UsernameNotFoundException("User is not found!");
        return user;
    }
    public Boolean addUser(String email, String password, String fullName, String gender, Integer age, String address){
        User user=userRep.findUserByEmail(email);
        Boolean result=Boolean.FALSE;
        if (user==null){
            List<Role> roles=new ArrayList<>();
            Role role=roleRep.getReferenceById(3L);
            roles.add(role);
            User u=new User();
            u.setEmail(email);
            u.setPassword(passwordEncoder.encode(password));
            u.setFullName(fullName);
            u.setGender(gender);
            u.setAge(age);
            u.setAddress(address);
            u.setRole(roles);
            userRep.save(u);
            result=Boolean.TRUE;
            return result;
        }
        return result;
    }
}
