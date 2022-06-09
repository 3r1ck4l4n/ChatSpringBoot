package mx.com.ipn.upiicsa.informatica.titulacion.chatexpertsystembackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
public class ChatExpertSystemBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatExpertSystemBackEndApplication.class, args);
    }

}
