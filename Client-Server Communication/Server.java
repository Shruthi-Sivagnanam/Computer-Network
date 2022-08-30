import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is started");
            System.out.println("Waiting for client");
            Socket socket = server.accept();
            DataInputStream clientData = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line="";
            while(!line.equals("Completed")){
                line = clientData.readUTF();
                System.out.println(line);
            }            
            System.out.println("Server is closing!!");
            server.close();
            socket.close();
            clientData.close();
            System.out.println("Connection closed!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
