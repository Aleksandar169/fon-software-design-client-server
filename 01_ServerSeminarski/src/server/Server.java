/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import threads.ClientHendler;

/**
 *
 * @author Lenovo
 */
public class Server extends Thread {

    boolean flag = false;
    ServerSocket serverSocket;
    List<ClientHendler> list = new ArrayList<>();

    public void startServer() throws IOException {

    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(9000);
            System.out.println("Cekam klijenta");
            while (!flag) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao");
                ClientHendler client = new ClientHendler(socket);
                list.add(client);
                client.start();

            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopServer() {
        flag = true;
        try {
            for (ClientHendler clientHendler : list) {
                clientHendler.stopThread();
            }
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
