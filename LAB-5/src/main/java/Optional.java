import java.util.LinkedList;
import java.util.Vector;

public class Optional {
    public static void main(String []args) throws Exception
    {
        Item book = new Book("Enigma Otiliei",1938,1,"George Calinescu","C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\sample.txt");
        Item image = new Image("Google",2020,1,"Unknown","C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\google.jpg");
        Item article = new Book("Morometii",-3,2,"Marin Preda","C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\readme.txt");

        // Pregatirea parametrilor cu care va fi apelat constructorul
        Vector<Item> items = new Vector<Item>();
        items.add(book);
        items.add(image);
        items.add(article);
        Catalog catalog = new Catalog("Vara-iarna 2022",items);

        // Testarea fiecarei comenzi
        // O problema ar fi path-urile eu testand cerintele atat pe Linux cat si pe Windows  .
        Report report = new  Report(catalog);
        Add add = new Add(catalog,new Book("Biblia",1000,10,"-","C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\readme.txt"));
        Catalog newCatalog = add.getCatalog();
        List list = new List(newCatalog);
        //Save save = new Save(catalog,"C:\\Users\\iulia\\Documents\\Facultate\\PA-LAB-V\\src\\Objects2.txt");
        //Play play = new Play(catalog);

    }
}
