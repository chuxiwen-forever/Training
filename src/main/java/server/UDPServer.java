package server;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UDPServer {
    private DatagramSocket socket = null;
    private String ip;
    private Integer port;
    private List<Map<String,Object>> list = new ArrayList<>();

    private UDPServer(String ip,Integer port){
        this.ip = ip;
        this.port = port;
    }

    public void garrison(){
        try {
            socket = new DatagramSocket(port,InetAddress.getByName(ip));
            while (true){
                //接收消息
                String message = receiveMessage();
                //发送消息
                sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }


    //接收信息并，返回消息，并将发消息人添加到Map列表中
    private String receiveMessage(){
        byte[] getMessage = new byte[1024];
        DatagramPacket getPacket = new DatagramPacket(getMessage,getMessage.length);
        try {
            socket.receive(getPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String getData = new String(getPacket.getData(),0,getPacket.getLength());
        InetAddress address = getPacket.getAddress();
        int port = getPacket.getPort();

        if (!isExist(address,port)){
            insertMap(address,port);
        }
        return getData;
    }

    //分发信息
    private void sendMessage(String data){
        for (Map<String,Object> computer : list){
            InetAddress addressIp = (InetAddress) computer.get("ip");
            Integer addressPort = (Integer) computer.get("port");
            byte[] messageByte = data.getBytes(StandardCharsets.UTF_8);
            DatagramPacket sendPacket = new DatagramPacket(messageByte, 0, messageByte.length, addressIp, addressPort);
            try {
                socket.send(sendPacket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //判断Map集合中是否有这次连接的ip和端口
    private boolean isExist(InetAddress ip , Integer port){
        boolean flag = false;
        for (Map<String,Object> computer : list){
            InetAddress addressIp = (InetAddress) computer.get("ip");
            Integer addressPort = (Integer) computer.get("port");
            if (addressIp.equals(ip)&&addressPort.equals(port)){
                flag = true;
            }
        }
        return flag;
    }

    //将ip和端口填入集合中
    private void insertMap(InetAddress ip,Integer port){
        Map<String,Object> map = new HashMap<>();
        map.put("ip",ip);
        map.put("port",port);
        list.add(map);
    }


}
