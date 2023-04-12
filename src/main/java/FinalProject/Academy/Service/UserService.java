package FinalProject.Academy.Service;

import FinalProject.Academy.Model.*;
import FinalProject.Academy.Repository.RoleRep;
import FinalProject.Academy.Repository.UserLvlRep;
import FinalProject.Academy.Repository.UserRep;
import FinalProject.Academy.map.AnswerMapper;
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
    @Autowired
    DeletedService deletedService;
    @Autowired
    UserAnswerService userAnswerService;
    @Autowired
    AnswerService answerService;
    @Autowired
    AnswerMapper answerMapper;
    @Autowired
    UserLvlRep userLvlRep;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRep.findUserByEmail(username);
        if (user==null)throw new UsernameNotFoundException("User is not found!");
        return user;
    }
    public Boolean addUser(String email, String password, String fullName, String gender, Integer age, String address){
        User user=userRep.findUserByEmail(email);
        Deleted deleted=deletedService.getBannedUser(email);
        Boolean result=Boolean.FALSE;
        if (user==null && deleted==null){
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
    public List<User> getTeachersByLevelAndFullName(String level, String fullName, String subject){
        Long role=2L;
        List<User> teachers=userRep.findAllByUserLevel_LvlAndFullNameContainingAndRole_idAndSubject_Name(level, fullName, role, subject);
        User user=userRep.findUserByRole_id(1l);
        teachers.remove(user);
        return teachers;
    }
    public List<User> getStudentsByLevelAndFullName(String level, String fullName, String subject){
        Long role=3L;
        List<User> students=userRep.findAllByUserLevel_LvlAndFullNameContainingAndRole_idAndSubject_Name(level,fullName,role,subject);
        User user=userRep.findUserByRole_id(1l);
        students.remove(user);
        return students;
    }
    public List<User> getStudentsByFullName(String fullName){
        Long role=3L;
        List<User> students=userRep.findAllByFullNameContainingAndRole_id(fullName,role);
        return students;
    }
    public List<User> getStudentsByLevel(String lvl){
        Long role=3L;
        List<User> students=userRep.findAllByUserLevelContainingAndRole_id(lvl,role);
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
    public void setUserLevel(Long answer_id){
        AnswerForTest answer= answerMapper.toEntity(answerService.getAnswerById(answer_id));
        List<UserAnswerForTest> list=userAnswerService.
                getAnswersByUser_id(getCurrentUser().getId(),answer.subject.getId());
        Integer all=0;
        for (UserAnswerForTest u:list){
            if (u.getTask().getLevel()==1){
                Boolean x=u.getAnswer().getStatus();
                if (x==Boolean.TRUE){
                    all+=1;
                }
            }else if (u.getTask().getLevel()==2){
                Boolean x=u.getAnswer().getStatus();
                if (x==Boolean.TRUE){
                    all+=2;
                }
            }else if (u.getTask().getLevel()==3){
                Boolean x=u.getAnswer().getStatus();
                if (x==Boolean.TRUE){
                    all+=3;
                }
            }
        }
        User user=getCurrentUser();
        user.setScore(all);
        if (all>=10){
            user.setUserLevel(userLvlRep.findById(3l).orElseThrow());
        }else if (all<10 && all>=5){
            user.setUserLevel(userLvlRep.findById(2l).orElseThrow());
        }else if (all<5){
            user.setUserLevel(userLvlRep.findById(1l).orElseThrow());
        }
        userRep.save(user);
    }
}
