package fr.mines.ales.web.services.tp.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class RoomService {
    private String message = new String("Hello,");
    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}