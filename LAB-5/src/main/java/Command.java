import java.util.LinkedList;

abstract class Command
{
    private String Name;
    private LinkedList<String> arguments;
    private Catalog catalog;
    /**
     * Setter pentru catalog
     * @return void
     * @param catalog
     */
    public void setCatalog(Catalog catalog)
    {
        this.catalog = catalog;
    }

    /**
     * Getter pentru catalog.
     * @return Catalog
     */
    public Catalog getCatalog(){
        return this.catalog;
    }
    /**
     * Getter pentru numele comenzii
     * @return String
     */
    public String getName() {
        return this.Name;
    }

    /**
     * Setter pentru numele comenzii
     * @param Name
     * @return void
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Getter pentru lista de argumente
     * @return LinkedList<String>
     */
    public LinkedList<String> getArguments() {
        return this.arguments;
    }

    /**
     * Setter pentru lista de argumente .
     * @param arguments
     * @return void
     */
    public void setArguments(LinkedList<String> arguments) {
        this.arguments = new LinkedList<>();
        this.arguments = arguments;
    }

    /**
     * Functie care verifica daca o comanda e corecta .
     * @return void
     * @throws InvalidCommand
     */
    public void validateCommand() throws InvalidCommand{
        if(this.getName().compareTo("save")!=0 && this.getName().compareTo("load")!=0 && this.getName().compareTo("play")!=0 && this.getName().compareTo("add")!=0 && this.getName().compareTo("list")!=0 && this.getName().compareTo("report")!=0)
            throw new InvalidCommand("Invalid command!");
    }
}
