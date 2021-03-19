import java.util.LinkedList;

class List extends Command
{
    /**
     * Constructor
     * @param catalog
     */
   List(Catalog catalog){
       this.setName("list");
       this.setCatalog(catalog);
       LinkedList<String> arguments = new LinkedList<>();
       arguments.add(this.getCatalog().getName());
       this.setArguments(arguments);
       this.setCatalog(catalog);
       try{
           this.validateCommand();
       }catch (InvalidCommand a)
       {
           System.out.println("Invalid command!");
       }
       this.getCatalog().list();
   }
}
