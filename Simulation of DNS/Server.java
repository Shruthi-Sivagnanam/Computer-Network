import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

/*
 * ip                 servername
 * 8.8.8.8            Google
 * 104.244.42.6	      twitter
 * 192.0.2.1          wikepedia
 */

public class Server {
    public static void main(String[] args) {
        ArrayList<String> ip =new ArrayList<String>();
        ip.add("8.8.8.8");
        ip.add("104.244.42.6");
        ip.add("192.0.2.1");
        ArrayList<String> serverName = new ArrayList<String>();
        serverName.add("google.com");
        serverName.add("twitter.com");
        serverName.add("wikipedia");
        try {
            DatagramSocket dsocket = new DatagramSocket(3000);
            byte[] dataReceived = new byte[65535];
             DatagramPacket dataPacket = null;
            while(true){
                dataPacket = new DatagramPacket(dataReceived, dataReceived.length);
                dsocket.receive(dataPacket);
                String line = new String(dataReceived,0,dataPacket.getLength());
                //System.out.println(line);
                byte[] data =null;
                if(ip.contains(line)){
                    int index = ip.indexOf(line);
                    data = serverName.get(index).getBytes();
                }
                if(serverName.contains(line)){
                    int index = serverName.indexOf(line);
                    data = ip.get(index).getBytes();
                }
                InetAddress clientAddress = dataPacket.getAddress();
                int clientPort = dataPacket.getPort();
                DatagramPacket finalData = new DatagramPacket(data, data.length, clientAddress, clientPort);
                dsocket.send(finalData);
                dataReceived = new byte[65535];
                if(line.equals("Completed")){
                    break;
                }
            }
            dsocket.close();    
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
