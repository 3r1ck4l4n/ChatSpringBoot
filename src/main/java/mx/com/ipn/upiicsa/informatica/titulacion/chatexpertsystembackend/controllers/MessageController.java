package mx.com.ipn.upiicsa.informatica.titulacion.chatexpertsystembackend.controllers;


import mx.com.ipn.upiicsa.informatica.titulacion.chatexpertsystembackend.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message getMessage(@Payload Message message){
        System.out.println(message.toString());
        return message;
    }



    @MessageMapping("/hello")
    public Message sendToUser(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getSendTo(),"/topic/messages",message);
        return message;
    }

}
