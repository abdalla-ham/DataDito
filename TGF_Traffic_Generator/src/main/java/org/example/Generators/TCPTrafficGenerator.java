package org.example.Generators;

import org.example.Config.TrafficConfiguration;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class TCPTrafficGenerator {

    public void generate(TrafficConfiguration config) {
        try (Socket socket = new Socket(config.getDestinationIP(), config.getDestinationPort())){
            OutputStream outputStream = socket.getOutputStream();
            byte[] packet = new byte[config.getPacketSize()];
            for (int i = 0; i < packet.length; i++) {
                packet[i] = (byte) i; // fills with smart data
            }

            int packetsPerSecond = config.getRate();
            long interval = 1000 / packetsPerSecond;

            int limit = config.getLimit(); // -1 means unlimited
            while (true){
                outputStream.write(packet);
                outputStream.flush();
                Thread.sleep(interval);
                limit = limit - 1;
                if (limit == 0){
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("Problem on Socket");
            System.out.println(e.getMessage());
        }catch (InterruptedException e){
            System.out.println("Problem on Thread");
            System.out.println(e.getMessage());
        }
    }
}
