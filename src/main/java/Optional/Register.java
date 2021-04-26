package Optional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Register {
    private static String username;

    Register (String user){
        this.username = user;
    }

    public void addUser() throws Exception
    {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            fw = new FileWriter("/home/iulian/Public/Facultate/Programare-avansata/LAB-10/src/Compulsory/users.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(username);
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
}
