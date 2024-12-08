package org.example.Config;

public class TrafficConfiguration {
    private String protocol;
    private String destinationIP;
    private int destinationPort;
    private int packetSize;
    private int rate; // packets per second
    private int limit;

    public TrafficConfiguration(String protocol, String destinationIP, int destinationPort, int packetSize, int rate) {
        this.protocol = protocol;
        this.destinationIP = destinationIP;
        this.destinationPort = destinationPort;
        this.packetSize = packetSize;
        this.rate = rate;
        this.limit = -1;
    }

    public TrafficConfiguration(String protocol, String destinationIP, int destinationPort, int packetSize, int rate, int limit) {
        this.protocol = protocol;
        this.destinationIP = destinationIP;
        this.destinationPort = destinationPort;
        this.packetSize = packetSize;
        this.rate = rate;
        this.limit = limit;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDestinationIP() {
        return destinationIP;
    }

    public int getDestinationPort() {
        return destinationPort;
    }

    public int getPacketSize() {
        return packetSize;
    }

    public int getRate() {
        return rate;
    }

    public int getLimit(){
        return limit;
    }
}
