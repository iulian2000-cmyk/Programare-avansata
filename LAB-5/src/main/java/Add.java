class Add extends Command
 {

    private Item item;

    Add(Catalog catalog,Item item)
    {
        this.setName("add");
        this.setCatalog(catalog);
        this.setItem(item);
        try{
            this.validateCommand();
        }catch (InvalidCommand a)
        {
            System.out.println("Invalid command!");
        }
        this.addCommand();
    }

     /**
      * Setter pentru numele item-ului
      * @return void
      * @param item
      */
    public  void setItem(Item item)
    {
        this.item = item;
    }

     /**
      * Getter pentru item
      * @return Item
      */
    public Item getItem()
    {
        return this.item;
    }
     /**
      * Functia care adauga la un catalog un item
      */
    public void addCommand()
    {
        this.getCatalog().add(this.item);
    }
}
