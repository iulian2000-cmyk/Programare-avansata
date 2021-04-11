import java.util.LinkedList;
import java.util.Vector;

/**
 * @author  Isac Iulian-George
 * Compulsory
 */
public class Main{
      public static void main (String []args){
            // Articolele catalogului
            Item book = new Book("Enigma Otiliei",1938,1,"George Calinescu","C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\sample.txt");
            Item image = new Image("Google",2020,1,"Unknown","C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\google.jpg");
            Item article = new Book("Morometii",-3,2,"Marin Preda","C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\readme.txt");

            // Pregatirea parametrilor cu care va fi apelat constructorul
            Vector<Item> items = new Vector<>();
            items.add(book);
            items.add(image);
            items.add(article);
            Catalog catalog = new Catalog("Vara-iarna 2022",items);

            // Functionalitati catalog
            catalog.list();
            //catalog.play(book);
            catalog.save("C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\Objects.txt");
            catalog.load("C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\Objects.txt");
            catalog.list();
      }
}
