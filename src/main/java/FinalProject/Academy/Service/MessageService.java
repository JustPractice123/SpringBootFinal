package FinalProject.Academy.Service;

import FinalProject.Academy.Model.Message;
import FinalProject.Academy.Repository.MessageRep;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
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
    public List<Message> getMessageBetweenTwoUser(Long id_one,Long id_two){
        List<Message> allList=new ArrayList<>();
        List<Message> toList=messageRep.findAllByFromuser_idAndTouser_Id(id_one,id_two);
        for (Message m:toList){
            allList.add(m);
        }
        int x=0;
        List<Message> fromList=messageRep.findAllByFromuser_idAndTouser_Id(id_two,id_one);
        for (Message m: fromList){
            for (Message a:allList){
                if (m==a){
                    x=1;
                }
            }
            if (x==0){
                allList.add(m);
            }
            x=0;
        }
        List<Long> listId=new ArrayList<>();
        for (Message m:allList){
            listId.add(m.getId());
        }
        listId=listId.stream().sorted().toList();
        List<Message> sortedMess=new ArrayList<>();
        for (Long l: listId){
            sortedMess.add(messageRep.findById(l).orElseThrow());
        }
        return sortedMess;
    }
}
