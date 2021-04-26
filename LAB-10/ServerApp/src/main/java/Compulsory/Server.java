package Compulsory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class Server {

    public static  void main(String[] args)
    {
        System.out.println("Running server...");
        ServerSocket server = null;
        boolean isRunning = true;
        try {
            server = new ServerSocket(1234);
            server.setReuseAddress(true);
            while (isRunning) {
                Socket client = server.accept();
                System.out.println("New client connected from IP: " + client.getInetAddress() .getHostAddress());
                TreatClient clientHandler = new TreatClient(client,server);
                new Thread(clientHandler).start();
            }
        }
        catch (SocketException e) {
            //e.printStackTrace();
            System.out.println("Sever stopped");
            isRunning = false;
        } catch (IOException b){
            //b.printStackTrace();
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