import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3000);
            Socket socket = server.accept();
            DataInputStream clientData1 = new DataInputStream(System.in);
            DataInputStream clientData = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream chat = new DataOutputStream(socket.getOutputStream());
            String line = "";
            while(!line.equals("BYE")){
                System.out.print("Client : ");
                line = clientData.readUTF();
                System.out.println(line);
                System.out.print("Server : ");
                line = clientData1.readLine();
                chat.writeUTF(line);
            }
            server.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}