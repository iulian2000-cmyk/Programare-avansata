package Optional;

import java.io.*;
import java.util.Scanner;

public class Message {
    String username;


    Message(String username){
        this.username = username;
    }
    public void sendMsg(String msg,Friends friend){
        String [] friends = friend.getFriends();
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

    public String readMsg(){
        String res = "";
        try {
            File fileReader = new File("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/messages.txt");
            Scanner Reader = new Scanner(fileReader);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String [] lineComponents = data.split(":");
                if(lineComponents[0].equals(username)) {
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
}
