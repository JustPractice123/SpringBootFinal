package FinalProject.Academy.api;

import FinalProject.Academy.Model.Message;
import FinalProject.Academy.Model.User;
import FinalProject.Academy.Service.MessageService;
import FinalProject.Academy.Service.UserService;
import FinalProject.Academy.dto.ChatDTO;
import FinalProject.Academy.map.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/chat")
public class ChatApi {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageMapper messageMapper;
    @GetMapping
    public List<User> getAllChat(){
        List<User> users=new ArrayList<>();
        List<Message> list=messageService.getMessageByFromuser_id(userService.getCurrentUser().getId());
        int count=0;
        for (Message m:list){
            for (User u:users){
                if (u==m.getTouser()){
                    count=1;
                }
            }
            if (count==0){
                users.add(m.getTouser());
            }
            count=0;
        }
        return users;
    }
    @GetMapping(value = "/{id}")
    public ChatDTO getChat(@PathVariable(name = "id")Long id){
        List<Message> messageListTo=messageService.getMessageByTouser_id(id);
        List<Message> messageListFrom=messageService.getMessageByFromuser_id(userService.getCurrentUser().getId());
        ChatDTO chatDTO=ChatDTO.builder()
                .to_user(messageMapper.toDTOlist(messageListTo))
                .from_user(messageMapper.toDTOlist(messageListFrom))
                .build();
        return chatDTO;
    }
}
