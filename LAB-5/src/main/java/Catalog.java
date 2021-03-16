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
import java.util.concurrent.*;
import java.util.Vector;

/**
* @author Isac Iulian-George
* Clasa Catalog 
 */
 
class Catalog {
    private String Name;
    private Vector<Item> items;

    /**
     * Getter pentru lista de item-uri
     * @return LinkedList<Item>
     */
    public Vector<Item> getItems(){
        return this.items;
    }
    /**
     * Setter pentru lista de item-uri
     * @return void
     * @param items
     */
    public void setItems(Vector<Item> items){
        this.items = new Vector<Item>();
        this.items = items;
    }
    /**
     * Getter pentru numele catalogului
     * @return String
     */
    public String getName(){
        return this.Name;
    }
    /**
     * Setter pentru numele catalogului
     * @param Name
     */
    public void setName(String Name){
        this.Name = Name;
    }
    /**
     * Metoda add care adauga in lista de item-uri
     *
     * @param items
     */
    Catalog(String Name,Vector<Item> items) {
        this.setName(Name);
        this.setItems(items);
    }

    public void add(Item item) {
        this.items.add(item);
    }

    /**
     * Metoda care afiseaza informatii despre fiecare item in parte
     *
     * @return void
     */
    public void list() {
        for (Item item : items) {
            System.out.println(item.getName() + "  " + item.getAuthor() + "  " + item.getYear() + "  " + item.getRating());
        }
    }

    /**
     * Metoda care afiseaza continutul fiecarui item in parte .
     *
     * @return void
     */
    public void play(Item item) {
       if(items.contains(item)){
           item.show();
       }else{
           System.out.println("Sorry the catalog doesn't containt this item anymore");
       }
    }

    /**
     * Metoda ce valideaza un an al lansarii
     * @param year
     * @return void
     * @throws InvalidYear
     */
    static void validateYear(int year) throws InvalidYear{
        if(year >  Calendar.getInstance().get(Calendar.YEAR) || year < 0)
            throw new InvalidYear("not valid");
    }
    /**
     * Metoda care salveaza toate item-urile intr-un fisier.
     *
     * @return void
     */
    public void save(String file) {
            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fos);
                for(Item item: this.items) {
                    out.writeObject(item);
                }
                fos.close();
                out.close();
            }catch (IOException e) {
                System.out.println("Exceptie");
            }
      }

    /**
     * Metoda ce incarca niste item-uri
     * @param file
     */
      public void load(String file)  {
          this.items.clear();
          this.items = new Vector<>();
          boolean reading = true;
          try{
              FileInputStream fis = new FileInputStream(file);
              ObjectInputStream in = new ObjectInputStream(fis);
              while(reading) {
                  Item item = (Item) in.readObject();
                  validateYear(item.getYear());
                  this.items.add(item);
              }
          }catch (IOException e){
              reading = false;
          }catch (ClassNotFoundException el){
              System.out.println("Class not found!");
          }catch (InvalidYear k)
          {
              System.out.println("Invalid year");
          }
      }
}