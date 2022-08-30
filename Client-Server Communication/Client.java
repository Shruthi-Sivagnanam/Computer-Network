import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client{
    public static void main(String[] args) {
        try{
             Socket socket = new Socket("127.0.0.1",5000);
             DataInputStream clientData = new DataInputStream(System.in);
             DataOutputStream serverOutput = new DataOutputStream(socket.getOutputStream());
             String line = "";
             while(!line.equals("Completed")){
                try {
                    line = clientData.readLine();
                    serverOutput.writeUTF(line);
                } catch (IOException e) {
                    System.out.println(e);
                }
             }
             clientData.close();
             serverOutput.close();
             socket.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
       
    }
}
