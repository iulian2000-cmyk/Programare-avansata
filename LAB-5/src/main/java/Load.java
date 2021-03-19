import java.util.LinkedList;

class Load extends Command{
    private Catalog catalog;
    private  String fileWhereIsSaved;

    /**
     * Constructor
     * @param catalog
     * @param file
     */
    Load (Catalog catalog, String file){
        this.setName("load");
        LinkedList<String> argumentsSaveCoomand = new LinkedList<>();
        argumentsSaveCoomand.add(this.catalog.getName());
        argumentsSaveCoomand.add(file);
        this.setArguments(argumentsSaveCoomand);
        this.setCatalog(catalog);
        try{
            this.validateCommand();
        }catch (InvalidCommand a)
        {
            System.out.println("Invalid command!");
        }
        this.loadCatalog();
    }

    /**
     * Setter pentru numele fisierului unde e salvat
     * @return void
     * @param file
     */
    public void setFileWhereIsSaved(String file){
        this.fileWhereIsSaved = file;
    }

    /**
     * Getter pentru numele fisierului unde e salvat catalogul.
     * @return String
     */
    public String getFileWhereIsSaved(){
        return this.fileWhereIsSaved;
    }
    public void loadCatalog()
    {
        this.catalog.load(this.fileWhereIsSaved);
    }
}
