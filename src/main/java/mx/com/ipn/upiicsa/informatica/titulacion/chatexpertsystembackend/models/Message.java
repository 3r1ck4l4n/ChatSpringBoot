package mx.com.ipn.upiicsa.informatica.titulacion.chatexpertsystembackend.models;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {

    private String content;
    private String sendTo;
    private String senderName;
    private String Date;
    private Status status;
}
