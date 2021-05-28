package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class SetLocale {
    public static void set(String prompt,String locales,String locale_set,String info ,String invalid) throws  Exception{
        FileOutputStream writer = new FileOutputStream("src/res/Messages.properties");
        writer.write(("").getBytes());
        writer.close();
        try (OutputStream output = new FileOutputStream("src/res/Messages.properties")) {
            Properties prop = new Properties();
            prop.setProperty("prompt",prompt);
            prop.setProperty("locales",locales);
            prop.setProperty("locale.set",locale_set);
            prop.setProperty("info",info);
            prop.setProperty("invalid",invalid);

            prop.store(output, null);
            prop.save(output,null);
            output.close();


        } catch (IOException io) {
            io.printStackTrace();
        }


    }
}
