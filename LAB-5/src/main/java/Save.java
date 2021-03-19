import java.util.LinkedList;

class Save extends Command
{
    private Catalog catalog;
    private  String fileWhereIsSaved;

    /**
     * Constructor
     * @param catalog
     * @param file
     */
    Save (Catalog catalog, String file){
        this.setName("save");
        this.setCatalog(catalog);
        LinkedList<String>argumentsSaveCoomand = new LinkedList<>();
        argumentsSaveCoomand.add(this.getCatalog().getName());
        argumentsSaveCoomand.add(file);
        this.setArguments(argumentsSaveCoomand);
        try{
            this.validateCommand();
        }catch (InvalidCommand a)
        {
            System.out.println("Invalid command!");
        }
        this.saveCatalog();
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
    public void saveCatalog()
    {
        this.getCatalog().save(this.fileWhereIsSaved);
    }
}
