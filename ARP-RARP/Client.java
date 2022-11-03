import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try {
            DatagramSocket dSocket = new DatagramSocket();
            InetAddress address = InetAddress.getLocalHost();
            byte[] data = null;
            System.out.println("Enter 'Completed' to stop the application");
            while (true) {
                System.out.print("Enter either ip or mac address: ");
                String line = reader.nextLine();
                data = line.getBytes();
                DatagramPacket dataPacket = new DatagramPacket(data, data.length, address, 3000);
                dSocket.send(dataPacket);

                byte[] finalData = new byte[65535];
                DatagramPacket dPacket = new DatagramPacket(finalData, finalData.length);
                dSocket.receive(dPacket);
                String finalans = new String(finalData, 0, dPacket.getLength());
                System.out.println(finalans);

                if (line.equals("Completed"))
                    break;
            }

            dSocket.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        reader.close();
    }
}
