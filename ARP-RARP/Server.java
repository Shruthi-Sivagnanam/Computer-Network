import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

/*
 * 
 * ip                   mac address
 * 192.168.86.45        98:90:96:B9:9D:61
 * 172.26.112.1         89:09:96:9B:9D:61
 */

public class Server {
    public static void main(String[] args) {
        ArrayList<String> ip = new ArrayList<String>();
        ip.add("192.168.86.45");
        ip.add("172.26.112.1");
        ArrayList<String> macaddress = new ArrayList<String>();
        macaddress.add("98:90:96:B9:9D:61");
        macaddress.add("89:09:96:9B:9D:61");
        try {
            DatagramSocket dSocket = new DatagramSocket(3000);
            byte[] dataRecieved = new byte[65535];
            DatagramPacket dPacket = null;
            while (true) {
                dPacket = new DatagramPacket(dataRecieved, dataRecieved.length);
                dSocket.receive(dPacket);
                String line = new String(dataRecieved, 0, dPacket.getLength());
                // System.out.println(line);

                byte[] data = null;
                if (ip.contains(line)) {
                    int index = ip.indexOf(line);
                    // System.out.println(macaddress.get(index));
                    data = macaddress.get(index).getBytes();
                }
                if (macaddress.contains(line)) {
                    int index = ip.indexOf(line);
                    // System.out.println(macaddress.get(index));
                    data = macaddress.get(index).getBytes();
                }
                InetAddress clientAddress = dPacket.getAddress();
                int clientPort = dPacket.getPort();
                DatagramPacket finalPacket = new DatagramPacket(data, data.length, clientAddress, clientPort);
                dSocket.send(finalPacket);
                // System.out.println(data);

                if (line.equals("Completed"))
                    break;
            }

            dSocket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
