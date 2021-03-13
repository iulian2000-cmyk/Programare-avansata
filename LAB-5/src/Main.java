
import java.lang.Object;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
              Item book = new Book("ABE-And Access Control",2020,1,"Yan-Zhu","/home/iulian/Public/Facultate/Licenta/Carte-licenta.pdf");
              LinkedList<Item> items = new LinkedList<>();
              items.add(book);
              Catalog catalog = new Catalog(items);
              catalog.list();
    }
}
