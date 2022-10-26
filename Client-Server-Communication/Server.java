import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        try {
            DatagramSocket dsocket = new DatagramSocket(3000);
            byte[] dataReceived = new byte[65535];
            DatagramPacket dataPacket = null;
            while(true){
                dataPacket = new DatagramPacket(dataReceived, dataReceived.length);
                dsocket.receive(dataPacket);
                String line = new String(dataReceived);
                System.out.println(line);
                dataReceived = new byte[65535];
                if(line.equals("Completed")){
                    break;
                }
            }
            dsocket.close();    
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
