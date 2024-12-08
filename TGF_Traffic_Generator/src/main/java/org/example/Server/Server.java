package org.example.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(52343)){
            System.out.println("Server started waiting for clients on port 52343");
            Socket accept = serverSocket.accept();
            System.out.println("Client connected");
            DataInputStream out = new DataInputStream(accept.getInputStream());
            String message = null;
            while (true){
                message = out.readUTF();
                System.out.println(message);
                if (message.isEmpty()){
                    System.out.println("no messages");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
