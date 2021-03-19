import java.util.LinkedList;
import java.util.Random;

class Play extends Command
{
    private Catalog catalog;

    /**
     * Constructor
     * @param catalog
     */
    Play(Catalog catalog){
        Random random = new Random();
        this.setName("play");
        LinkedList<String > argumentsThisCommand = new LinkedList<>();
        argumentsThisCommand.add(this.catalog.getName());
        this.setArguments(argumentsThisCommand);
        this.setCatalog(catalog);
        try{
            this.validateCommand();
        }catch (InvalidCommand a) {
            System.out.println("Invalid command!");
        }
        this.getCatalog().play(this.getCatalog().getItems().get(random.nextInt(this.getCatalog().getItems().size())));
    }
}
