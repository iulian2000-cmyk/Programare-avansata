package Optional;



import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


class TreatClientOptional implements Runnable{
    private Socket clientSocket;
    private ServerSocket serverSocket;

    public TreatClientOptional(Socket socket,ServerSocket serverSocket) throws Exception
    {
        this.serverSocket = serverSocket;
        this.clientSocket = socket;
        //this.clientSocket.setSoTimeout(1000);
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
                    Login login = new Login(commandline[1]);
                    if(login.isUser())
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
                    Register register = new Register(commandline[1]);
                    try {
                        register.addUser();
                    }catch (Exception a){
                        a.printStackTrace();
                    }
                    answerToClient = "User added with success!";
                }

                if(commandline[0].equals("friend"))
                {
                    String []friends = commandline[1].split(",");
                    Friends friend = new Friends(username);
                    try {
                        friend.addFriends(friends);
                        answerToClient="Friends added with succes";
                    }catch (Exception a){
                        a.printStackTrace();
                    }
                }
                if(commandline[0].equals("send")){
                    Message message = new Message(username);
                    Friends friend = new Friends(username);
                    String msg = commandline[1];
                    message.sendMsg(msg,friend);
                    answerToClient = "Message sent ! ";
                }
                if (commandline[0].equals("read")){
                    Message message = new Message(username);
                    answerToClient =  message.readMsg();
                }
                if(msgFromClient.equals("stop")){
                    clientSocket.close();
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
