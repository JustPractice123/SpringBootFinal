package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Message;
import FinalProject.Academy.Repository.MessageRep;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class MessageService {
    @Autowired
    private MessageRep messageRep;
    @Autowired
    private UserService userService;
    @Autowired
    private ChildrenService childrenService;
    public void createMessage(Long id_to,String text){
        Message message=new Message();
        message.setMessage(text);
        message.setTouser(userService.getUserById(id_to));
        message.setFromuser(userService.getCurrentUser());
        messageRep.save(message);
    }
    public List<Message> getMessageByFromuser_id(Long id){
        List<Message> list=messageRep.findAllByFromuser_id(id);
        return list;
    }
    public List<Message> getMessageByTouser_id(Long id){
        List<Message> list=messageRep.findAllByTouser_id(id);
        return list;
    }
}
