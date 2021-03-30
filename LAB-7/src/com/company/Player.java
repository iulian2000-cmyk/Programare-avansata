package com.company;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Player {

    public static void main(String []args)
    {
        try (Socket socket = new Socket("localhost", 1234)) {
            PrintWriter out = new PrintWriter( socket.getOutputStream(), true);
            BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int score=0;
            for(int indexToken=0;indexToken<15;indexToken++)
            {
                int i = Integer.parseInt(in.readLine());
                int j = Integer.parseInt(in.readLine());
                System.out.println("( " + i + " ," +  j  + " )");
                score = score + i+j;
                out.flush();
            }
            System.out.println("I AM HERE");
            String pos=null;
            while(pos == null)
            {
                pos = in.readLine();
            }
            System.out.print("\033[H\033[2J");
            System.out.println("                                                 You finished   " + pos );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}