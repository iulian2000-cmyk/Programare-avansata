
package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client{

    public static void main(String []args)
    {
            try (Socket socket = new Socket("localhost", 1234)) {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msgToServer = "", answerFromServer;
                Scanner reader = new Scanner(System.in);

                while (!msgToServer.equals("exit")) {
                    System.out.print("$:");
                    msgToServer = reader.nextLine();
                    System.out.println("Message to sever: " + msgToServer);
                    out.println(msgToServer);
                    out.flush();
                    answerFromServer = in.readLine();

                    System.out.println("Answer from server: " + answerFromServer);
                }
            } catch (IOException a) {
                a.printStackTrace();
            }
        }
    }
