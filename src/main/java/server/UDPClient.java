package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class UDPClient {
    private DatagramSocket socket;
    {
        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private String ip;
    private Integer port;
    public UDPClient(String ip , Integer port){
        this.ip = ip;
        this.port = port;
    }

    //给服务器发消息
    public void sendMessage(String message){
        byte[] msg = message.getBytes(StandardCharsets.UTF_8);
        try {
            DatagramPacket packet = new DatagramPacket(msg, 0, msg.length, InetAddress.getByName(ip),port);
            socket.send(packet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //接收服务器回传的消息
    public String receiveMessage(){
        String message = null;
        byte[] msg = new byte[1024];
        DatagramPacket packet = new DatagramPacket(msg, msg.length);
        try {
            socket.receive(packet);
            message = new String(packet.getData(),0,packet.getLength());
        } catch (IOException e) {
            System.out.println("客户端断开连接了...");
        }
        return message;
    }

    public void close(){
        socket.close();
    }
}
