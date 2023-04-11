package FinalProject.Academy.api;

import FinalProject.Academy.Model.Message;
import FinalProject.Academy.Service.MessageService;
import FinalProject.Academy.Service.UserService;
import FinalProject.Academy.dto.ChatDTO;
import FinalProject.Academy.map.MessageMapper;
import FinalProject.Academy.map.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/chat/{id}")
public class ChatApi {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private UserMapper userMapper;
    @GetMapping
    public ChatDTO getChat(@PathVariable(name = "id")Long id){
        if (userService.getCurrentUser()!=null){
            ChatDTO chatDTO= ChatDTO.builder()
                    .user(userService.getUserById(id))
                    .allMessage(messageService
                            .getMessageBetweenTwoUser(userService
                                            .getCurrentUser().getId(),
                                    id))
                    .build();
            return chatDTO;
        }else {

            return null;
        }
    }
    @PostMapping
    public void sendMess(@RequestBody Message message){
        messageService.createMessage(message.touser.getId(),message.message);
    }
}
