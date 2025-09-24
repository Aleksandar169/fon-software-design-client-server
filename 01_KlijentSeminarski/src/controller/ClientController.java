/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class ClientController {
    private Socket socket;
    private Sender sender;
    private Receiver receiver;

    public ClientController() {
        
        try {
            socket=new Socket("localhost", 9000);
            sender=new Sender(socket);
            receiver=new Receiver(socket);
        } catch (IOException ex) {
            Logger.getLogger(ClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object sendRequest (Operation operation, Object object) throws Exception{
        sender.send(new Request(operation, object));
        Response response=(Response) receiver.receive();
        
        if(response.getException()!=null){
            throw response.getException();
        }
        return response.getResult();
    }
    
}
