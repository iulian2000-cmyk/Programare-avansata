package com.company;

import com.sun.source.tree.Scope;

import javax.naming.ldap.SortKey;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.SocketSecurityException;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.DoubleToIntFunction;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.onSpinWait;


public class Board  {
    public static void main(String []args) throws IOException,InterruptedException {
        int numberTokens = 30;
        int numberPlayers = 2;

        Vector <Token> tokens = new Vector<>();
        Random random = new Random();
        Vector<Token> tokensInitialFirstPlayer = new Vector<Token>();
        Vector<Token> tokensInitialSecondPlayer = new Vector<Token>();
        int scoreFirstPlayer=0,scoreSecondPlayer=0;

        for(int index=0;index<15;index++)
        {
            Token tokenA = new Token(new Random().nextInt(100),new Random().nextInt(200));
            Token tokenB = new Token(new Random().nextInt(100),new Random().nextInt(200));
            scoreFirstPlayer = scoreSecondPlayer + tokenA.getI()+tokenA.getJ();
            scoreSecondPlayer = scoreFirstPlayer + tokenB.getI()+tokenB.getJ();
            tokensInitialFirstPlayer.add(tokenA);
            tokensInitialSecondPlayer.add(tokenB);
        }

        ServerSocket server = new ServerSocket(1234);
        server.setReuseAddress(true);
        Vector<TreatPlayer> players = new Vector<TreatPlayer>();
        Vector<Socket> sockets = new Vector<Socket>();
        TreatPlayer player;
        for(int indexPlayer=1;indexPlayer<=numberPlayers;indexPlayer++)
        {
            Socket playerSocket = server.accept();
            if(indexPlayer == 1) {
                player = new TreatPlayer(indexPlayer, tokensInitialFirstPlayer, playerSocket);
            }else{
                player = new TreatPlayer(indexPlayer,tokensInitialSecondPlayer,playerSocket);
            }
            sockets.add(playerSocket);
            Thread threadPlayer = new Thread(player);
            threadPlayer.start();
            System.out.println("The player with id " + indexPlayer + " is connecting !");
            players.add(player);
        }
        System.out.println("The first player score : " + scoreFirstPlayer);
        System.out.println("The second player score : " + scoreSecondPlayer );
        String msgForFirstPlayer="",msgForSecondPlayer="";
        if(scoreFirstPlayer < scoreSecondPlayer)
        {
            msgForFirstPlayer = " second !";
            msgForSecondPlayer = "first ! ";
        }else{
            if(scoreFirstPlayer > scoreSecondPlayer )
            {
                msgForFirstPlayer = " first !";
                msgForSecondPlayer = "second !";
            }else{
                msgForFirstPlayer  = "first !";
                msgForSecondPlayer = "first ! ";
            }
        }
        TimeUnit.SECONDS.sleep(30);
        for(int indexPlayer = 1;indexPlayer <=numberPlayers;indexPlayer++)
        {
            PrintWriter out = new PrintWriter(sockets.elementAt(indexPlayer-1).getOutputStream(),true);
            //BufferedReader in = new BufferedReader(new InputStreamReader(sockets.elementAt(indexPlayer).getInputStream()));
            if(indexPlayer == 1)
            {
               out.println(msgForFirstPlayer);
            }else{
                out.println(msgForSecondPlayer);
            }
        }
    }
}
