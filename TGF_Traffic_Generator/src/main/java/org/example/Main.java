package org.example;

import org.example.Config.TrafficConfiguration;
import org.example.Generators.TCPTrafficGenerator;
import org.example.Server.Server;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                    Welcome to

                    ___      _                ___ _ _          _____  ___   ___\s
                   /   \\__ _| |_ __ _        /   (_) |_ ___   /__   \\/ _ \\ / __\\
                  / / \\ / _` | __/ _` |_____ / / \\ / | __/ _ \\    / /\\/ /_\\// _\\ \s
                 / /_// (_| | || (_| |_____/ /_//| | || (_) |  / / / /_\\\\/ /   \s
                /___,' \\__,_|\\__\\__,_|    /___,' |_|\\__\\___/   \\/  \\____/\\/    \s
                                                                               \s
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose a protocol: (1) TCP (2) UDP");
        int protocol = Integer.parseInt(scanner.nextLine());
        if (protocol != 1 && protocol != 2) {
            System.out.println("Unknown protocol");
        }
        System.out.println("Please give a destination IP address");
        String destination = scanner.nextLine();
        System.out.println("Please give a source Port address");
        int sourcePort = scanner.nextInt();
        System.out.println("Please give a packet size");
        int packetSize = scanner.nextInt();
        System.out.println("Please give a rate (packets per second)");
        int rate = scanner.nextInt();
        System.out.println("Please set a limit (optional)");
        int limit = -1;
        limit = scanner.nextInt();

        TrafficConfiguration trafficConfiguration = new TrafficConfiguration(
                protocol == 1 ? "TCP" : "UDP",
                destination,
                sourcePort,
                packetSize,
                rate,
                limit
        );

        if (trafficConfiguration.getProtocol().equals("TCP")){
            System.out.println("TCP Traffic Started");
            new TCPTrafficGenerator().generate(trafficConfiguration);
        }
    }
}