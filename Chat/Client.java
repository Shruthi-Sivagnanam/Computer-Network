import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",3000);
            DataInputStream clientData = new DataInputStream(System.in);
            DataOutputStream chat = new DataOutputStream(socket.getOutputStream());
            DataInputStream clientData1 = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while(!line.equals("BYE")){
                System.out.print("Client : ");
                line = clientData.readLine();
                chat.writeUTF(line);
                System.out.print("Server : ");
                line = clientData1.readUTF();
                System.out.println(line);
            }
            socket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
