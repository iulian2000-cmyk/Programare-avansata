
import java.awt.event.ItemEvent;
import java.lang.reflect.Array;
import java.util.*;
import java.io.File;
import java.awt.*;
import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

class Catalog {

     private LinkedList<Item> items ;

    /**
     * Metoda add care adauga in lista de item-uri
     * @param items
     */
    Catalog(LinkedList <Item> items)
    {
        this.items = new LinkedList<>();
        this.items = items;
    }
     public void add(Item item)
     {
         this.items.add(item);
     }

    /**
     * Metoda list ce printeaza continutul item-urilor.
     */
    public void list()
     {
         for(Item item : items )
         {
             System.out.println("Vizualizarea item-ului  " + item.getName());
             try {
                 File file = new File(item.getPath());
                 Desktop desk = Desktop.getDesktop();
                 if(desk.isSupported(Desktop.Action.PRINT))
                 {
                     System.out.println("Printarea nu poate fi realizata pe aceasta platforma");
                 }else {
                     try {
                         desk.print(file);
                     }catch (java.io.IOException e)
                     {
                         System.out.println("Java exception IO");
                     }
                 }
             } catch ( java.awt.HeadlessException evt) {
                   System.out.println("A aparut o exceptie ! ");
             }
         }
     }

}
