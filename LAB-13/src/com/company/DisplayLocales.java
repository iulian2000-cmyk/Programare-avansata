package com.company;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public static ResourceBundle getMessages() {
        return messages;
    }

    public static void setMessages(ResourceBundle messages) {
        DisplayLocales.messages = messages;
    }

    public static String getBaseName() {
        return baseName;
    }

    private static String baseName;
    private static ResourceBundle messages;


    public static void displayAll(Locale locale){
        String baseName = "res.Messages";

        ResourceBundle messages = ResourceBundle.getBundle(baseName,locale);
        System.out.println("prompt = " + messages.getString("prompt"));
        System.out.println("locales = " + messages.getString("locales"));
        System.out.println("locale.set = " + messages.getString("locale.set"));
        System.out.println("info = " + messages.getString("info"));
        System.out.println("invalid = " + messages.getString("invalid"));

    }






}
