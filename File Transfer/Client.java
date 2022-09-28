import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            String filelocation = "";
            Socket socket = new Socket("localhost", 3000);
            Scanner reader = new Scanner(System.in);
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            System.out.println("Enter the location of the file to be tranfered: ");
            filelocation = reader.nextLine();
            File file = new File(filelocation);
            FileInputStream fileInput = new FileInputStream(file);
            output.writeLong(file.length());
            byte[] buffer = new byte[4 * 1024];
            int bytes = 0;
            if ((bytes = fileInput.read(buffer)) != -1) {
                output.write(buffer, 0, bytes);
                output.flush();
            }
            fileInput.close();
            socket.close();
            reader.close();
            System.out.println("File transfered successfully");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
