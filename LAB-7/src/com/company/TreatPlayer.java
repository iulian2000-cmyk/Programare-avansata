package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;
import java.util.Vector;

class TreatPlayer implements Runnable{
    private  Vector<Token> tokens;
    private static Socket socketPlayerBoard;
    private int idPlayer;
    private volatile boolean exit = false;

    public Vector<Token> getTokens(){
        return tokens;
    }
    TreatPlayer(int id , Vector<Token> tokens, Socket socketPlayer)
    {
        this.idPlayer = id;
        this.tokens = new Vector<Token>();
        this.tokens = tokens;
        this.socketPlayerBoard = socketPlayer;
    }
    @Override
    public void run() {
        try{
             PrintWriter out = new PrintWriter(socketPlayerBoard.getOutputStream(),true);
             System.out.println("Number tokens player with id " + idPlayer + "  " + tokens.size());
             for(int i=0;i<tokens.size();i++)
             {
                 Token token = tokens.elementAt(i);
                 out.println(token.getI());
                 out.println(token.getJ());
                 out.flush();
             }
             stop();
        }catch (IOException a) {
            a.printStackTrace();
        }
    }
    public void stop() {
        exit = true;
    }
}
