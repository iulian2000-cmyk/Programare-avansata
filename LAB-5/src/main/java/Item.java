import java.awt.*;
import java.io.File;
import java.io.IOException;

abstract class Item {
     private String path;
     private String Name;

    /**
     * Setter pentru Name
     * @param Name
     */
     public void setName(String Name)
     {
         this.Name = Name;
     }
    /**
     * Getter pentru path
     * @return String
     */
     public String getPath(){
         return this.path;
     }

    /**
     * Setter pentru path
     * @param path
     * @return void
     */
     public void setPath(String path){
         this.path = path;
     }

    /**
     * Getter pentru Name
     * @return String
     */
    public String getName(){
        return this.Name;
    }
    /**
     * Metoda show de arata un item
     * @return void
     */
    public void show() {
        Desktop desk = Desktop.getDesktop();
        File fileItem = new File(this.getPath());
        try {
            desk.print(fileItem);
        }catch (IOException e) {
            System.out.println("Exceptie IOException ! ");
        }
    }

    /**
     * Getter pentru autor
     * @return String
     */
    abstract public String getAuthor();

    /**
     * Getter pentru an
     * @return int
     */
    abstract public int getYear();

    /**
     * Getter pentru rating
     * @return int
     */
    abstract public int getRating();
}