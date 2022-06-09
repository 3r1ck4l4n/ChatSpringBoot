package mx.com.ipn.upiicsa.informatica.titulacion.chatexpertsystembackend.models;

import java.security.Principal;

public class User implements Principal {
    private String name;

    public User(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
}
