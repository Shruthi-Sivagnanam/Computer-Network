import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(3000);
            System.out.println("Server running in port 3000");
            Socket socket = server.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            FileOutputStream fileOutput = new FileOutputStream("New.txt");
            int bytes = 0;
            long size = input.readLong();
            byte[] buffer = new byte[4 * 1024];
            while (size > 0 && (bytes = input.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                fileOutput.write(buffer, 0, bytes);
                size -= bytes;
            }
            fileOutput.close();
            server.close();
            output.close();
            System.out.println("File received successfully");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
