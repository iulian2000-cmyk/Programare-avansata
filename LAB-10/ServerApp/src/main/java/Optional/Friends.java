package Optional;

import java.io.*;
import java.util.Scanner;

public class Friends {
    private static String username;

    Friends(String username){
        this.username = username;
    }

    public void addFriends(String [] friends) throws Exception
    {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/ServerApp/src/main/java/Compulsory/friends.txt", true);
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

    public String [] getFriends (){
        String [] res = {""};
        try {
            File fileReader = new File("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/ServerApp/src/main/java/Compulsory/friends.txt");
            Scanner Reader = new Scanner(fileReader);
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                String [] lineComponents = data.split(":");
                if(lineComponents[0].equals(username)){
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
}
