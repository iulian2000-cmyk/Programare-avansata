package Optional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    private static String username;

    Login(String username){
        this.username = username;
    }
    public static boolean isUser()
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
}
