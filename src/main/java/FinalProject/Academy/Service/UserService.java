package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Role;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Repository.RoleRep;
import FinalProject.Academy.Repository.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public User getUserById(Long id){

        return userRep.findUserById(id);
    }
    public User getCurrentUser(){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)){
            User user=(User) authentication.getPrincipal();
            return user;
        }return null;
    }
    public void changeUser(Long id, String fullName,String gender, Integer age,String address){
        User user=getUserById(id);
        user.setFullName(fullName);
        user.setGender(gender);
        user.setAge(age);
        user.setAddress(address);
        userRep.save(user);
    }
    public void changePassword(String password,Long id){
        User user=getUserById(id);
        user.setPassword(passwordEncoder.encode(password));
        userRep.save(user);
    }
    public List<User> getTeachers(){
        List<User> teachers=userRep.findAllByRole_id(2l);
        User user=userRep.findUserByRole_id(1l);
        teachers.remove(user);
        return teachers;
    }
    public List<User> getStudents(){
        List<User> students=userRep.findAllByRole_id(3l);
        User user=userRep.findUserByRole_id(1l);
        students.remove(user);
        return students;
    }
    public List<User> getTeachersByLevelAndFullName(String level, String fullName){
        Long role=2L;
        List<User> teachers=userRep.findAllByUserLevel_LvlAndFullNameContainingAndRole_id(level, fullName, role);
        User user=userRep.findUserByRole_id(1l);
        teachers.remove(user);
        return teachers;
    }
    public List<User> getStudentsByLevelAndFullName(String level, String fullName){
        Long role=3L;
        List<User> students=userRep.findAllByUserLevel_LvlAndFullNameContainingAndRole_id(level,fullName,role);
        User user=userRep.findUserByRole_id(1l);
        students.remove(user);
        return students;
    }
    public List<User> getStudentsByFullName(String fullName){
        Long role=3L;
        List<User> students=userRep.findAllByFullNameContainingAndRole_id(fullName,role);
        return students;
    }
    public List<User> getAllUsers(){
        List<User> users=userRep.findAll();
        User user=userRep.findUserByRole_id(1L);
        users.remove(user);
        return users;
    }
    public void save(User user){
        userRep.save(user);
    }
    public void deleteUser(Long id){
        User user=userRep.findUserById(id);
        userRep.delete(user);
    }
}
