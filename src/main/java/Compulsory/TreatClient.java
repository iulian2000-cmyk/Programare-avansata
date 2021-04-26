package Compulsory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


class TreatClient implements Runnable{
    private Socket clientSocket;
    private ServerSocket serverSocket;
    private HashMap<String,List<String>>messages;

    public TreatClient(Socket socket,ServerSocket serverSocket)
    {
        this.serverSocket = serverSocket;
        this.clientSocket = socket;
        this.messages = new HashMap<>();
    }
     public static boolean isUser(String username)
     {
         try {
             File fileReader = new File("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/users.txt");
             Scanner Reader = new Scanner(fileReader);
             while (Reader.hasNextLine()) {
                 String data = Reader.nextLine();
                 //System.out.println(data + "-" + username);
                 if(data.equals(username)){
                     return true;
                 }
             }
             Reader.close();
              }catch(FileNotFoundException e){
                 System.out.println("An error occurred.");
                 e.printStackTrace();
             }
         return false;
     }
     public void addFriends(String [] friends,String username) throws Exception
     {
         FileWriter fw = null;
         BufferedWriter bw = null;
         PrintWriter pw = null;
         try {
             fw = new FileWriter("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/friends.txt", true);
             bw = new BufferedWriter(fw);
             pw = new PrintWriter(bw);
             pw.print(username + ":");
             String friend;
             for(int index=0;index<friends.length;index++) {
                 friend = friends[index];
                 friend.replaceAll("\n", "");
                 if (index!= friends.length-1) {
                     pw.print(friend + ",");
                 }else{
                     pw.print(friend);
                 }
             }
             //System.out.println("Data Successfully appended into file");
             pw.flush();
         } finally {
             try {
                 pw.close();
                 bw.close();
                 fw.close();
             } catch (IOException io) {
                 io.printStackTrace();
             }
         }
     }

     public void addUser(String user) throws Exception
     {
         FileWriter fw = null;
         BufferedWriter bw = null;
         PrintWriter pw = null;

         try {
             fw = new FileWriter("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/users.txt", true);
             bw = new BufferedWriter(fw);
             pw = new PrintWriter(bw);
             pw.println(user);
             //System.out.println("Data Successfully appended into file");
             pw.flush();
         } finally {
             try {
                 pw.close();
                 bw.close();
                 fw.close();
             } catch (IOException io) {
                 io.printStackTrace();
             }
         }
     }
     public String [] getFriends (String user){
        String [] res = {""};
         try {
             File fileReader = new File("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/friends.txt");
             Scanner Reader = new Scanner(fileReader);
             while (Reader.hasNextLine()) {
                 String data = Reader.nextLine();
                 String [] lineComponents = data.split(":");
                 if(lineComponents[0].equals(user)){
                     res = lineComponents[1].split(",");
                 }
             }
             Reader.close();
         }catch(FileNotFoundException e){
             System.out.println("An error occurred.");
             e.printStackTrace();
         }
         return res;
     }
     public void sendMsg(String user,String msg){
        String [] friends = getFriends(user);
        for(int i=0;i<friends.length;i++)
        {
            FileWriter fw = null;
            BufferedWriter bw = null;
            PrintWriter pw = null;
            try {
                fw = new FileWriter("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/messages.txt", true);
                bw = new BufferedWriter(fw);
                pw = new PrintWriter(bw);
                pw.println(friends[i] + ":" + msg);
                //System.out.println("Data Successfully appended into file");
                pw.flush();
            }catch (IOException a){
                a.printStackTrace();
            } finally {
                try {
                    pw.close();
                    bw.close();
                    fw.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }
     }

    public String readMsg(String user){
        String res = "";
        try {
            File fileReader = new File("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/messages.txt");
            Scanner Reader = new Scanner(fileReader);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String [] lineComponents = data.split(":");
                if(lineComponents[0].equals(user)) {
                    res = res + "-" + lineComponents[1] + "-";
                }
            }
            Reader.close();
        }catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return res;
    }

    @Override
     public void run() {
         try{
             String msgFromClient = null,answerToClient="",username="";
             String clientAddress = clientSocket.getInetAddress().getHostAddress();
             String [] commandline;
             System.out.println("\r\nNew connection from " + clientAddress);

             BufferedReader in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter( clientSocket.getOutputStream(), true);
             while ((msgFromClient = in.readLine()) != null)
             {
                 System.out.println("\r\nMessage from " + clientAddress + ": " + msgFromClient);
                 commandline = msgFromClient.split(":");

                 if(msgFromClient.equals("exit")){
                     answerToClient="See u soon!";
                 }
                 if (commandline[0].equals("login"))
                 {
                     commandline[1].replaceAll("\n","");
                     if(isUser(commandline[1]))
                     {
                         answerToClient="Welcome back!";
                         username = commandline[1];
                     }else{
                         answerToClient="This is not an account!";
                     }
                 }
                 if(commandline[0].equals("register"))
                 {
                     System.out.println("User to add :" + commandline[1] );
                     try {
                         addUser(commandline[1]);
                     }catch (Exception a){
                         a.printStackTrace();
                     }
                     answerToClient = "User added with success!";
                 }
                 if(commandline[0].equals("friend"))
                 {
                     String []friends = commandline[1].split(",");
                     try {
                         addFriends(friends,username);
                         answerToClient="Friends added with succes";
                     }catch (Exception a){
                         a.printStackTrace();
                     }
                 }
                 if(commandline[0].equals("send")){
                         String msg = commandline[1];
                         sendMsg(username,msg);
                         answerToClient = "Message sent ! ";
                 }
                 if (commandline[0].equals("read")){
                     answerToClient = readMsg(username);
                 }
                 if(msgFromClient.equals("stop")){
                     serverSocket.close();
                     msgFromClient="exit";
                     out.println("Server stopped");
                     out.close();
                     in.close();
                 }else {
                     out.println(answerToClient);
                     out.flush();
                 }
             }
         }catch(IOException a) {
             System.out.println("IOException");
         }
     }
 }
