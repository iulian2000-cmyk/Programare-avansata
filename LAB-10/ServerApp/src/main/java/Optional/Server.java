package Optional;





import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class Server {

    public static  void main(String[] args) throws Exception
    {
        System.out.println("Running server...");
        ServerSocket server = null;
        boolean isRunning = true;
        boolean receivingOther = true;
        try {
            server = new ServerSocket(1234);
            //server.setSoTimeout(10000);
            server.setReuseAddress(true);
            while (isRunning) {
                if (receivingOther) {
                    Socket client = server.accept();
                    System.out.println("New client connected from IP: " + client.getInetAddress().getHostAddress());
                    client.setSoTimeout(10000);
                    TreatClientOptional clientHandler = new TreatClientOptional(client, server);
                    new Thread(clientHandler).start();
                }
            }
        }
        catch (SocketException e) {
            //e.printStackTrace();
            System.out.println("Sever stopped~");
            receivingOther = false;
        } catch (IOException b){
            b.printStackTrace();

        }finally {
            if (server != null) {
                try {
                    server.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}