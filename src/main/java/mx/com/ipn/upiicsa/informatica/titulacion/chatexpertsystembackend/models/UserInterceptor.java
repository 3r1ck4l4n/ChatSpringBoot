package mx.com.ipn.upiicsa.informatica.titulacion.chatexpertsystembackend.models;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;

import java.util.ArrayList;
import java.util.Map;

public class UserInterceptor implements ChannelInterceptor {

    Logger logger = LoggerFactory.getLogger(UserInterceptor.class);
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        logger.info(accessor.toString());
        if (StompCommand.CONNECT.equals(accessor.getCommand())) {
            Object raw = message.getHeaders().get(SimpMessageHeaderAccessor.NATIVE_HEADERS);

            if (raw instanceof Map) {
                Object name = ((Map) raw).get("username");

                if (name != null)logger.info(name.toString());
                if (name instanceof ArrayList) {
                    accessor.setUser(new User(((ArrayList<String>) name).get(0).toString()));
                }
            }
        }
        return message;
    }
}
