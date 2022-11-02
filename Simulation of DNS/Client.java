import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try{
            DatagramSocket dsocket = new DatagramSocket();
            InetAddress ip = InetAddress.getLocalHost();
            byte[] data=null;
            System.out.println("Enter 'Completed' to stop the program");

            while(true){
                System.out.print("Enter the either ip or server name : ");
                String inp=reader.nextLine();
                data = inp.getBytes();
                DatagramPacket dataPacket = new DatagramPacket(data, data.length,ip,3000);
                dsocket.send(dataPacket);

                byte[] finalData = new byte[65535];
                DatagramPacket response = new DatagramPacket(finalData, finalData.length) ;
                dsocket.receive(response);

                String newData = new String(finalData);
                System.out.println(newData);

                if(inp.equals("Completed"))
                break;
            }
            dsocket.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        reader.close();
    }
}
