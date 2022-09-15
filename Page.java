import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Page {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 8080;
        try (Socket s = new Socket(hostname,port)){
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out.println("GET / HTTP/1.1\nHost: 127.0.0.1\n\n");
            PrintWriter f = new PrintWriter(new File("sample.html"));
            String inputLine;
            while((inputLine = in.readLine())!=null){
                f.write(inputLine);
            }
            f.close();
            System.out.println("File saved in the current folder");
            
        } catch (Exception e) {
            System.out.println("Something went wrong!!");
        }
    }
}
