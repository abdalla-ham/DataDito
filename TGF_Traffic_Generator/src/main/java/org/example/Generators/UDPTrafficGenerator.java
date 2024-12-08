package org.example.Generators;

import org.example.Config.TrafficConfiguration;

import java.io.IOException;
import java.net.*;

public class UDPTrafficGenerator {
    public static void generate(TrafficConfiguration config) {

        try{
            DatagramSocket socket = new DatagramSocket();
        }
        catch (SocketException exception){
            System.out.println(exception.getMessage());
        }

    }
}
