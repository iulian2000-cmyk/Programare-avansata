import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

class Image extends Item implements Serializable {
    private String Name;
    private int year;
    private int rating;
    private String author;
    private String path;

    /**
     * Constructor
     * @param Name
     * @param year
     * @param rating
     * @param author
     * @param path
     */
    Image(String Name,int year,int rating,String author,String path)
    {
        this.setName(Name);
        this.setYearRelease(year);
        this.setRating(rating);
        this.setAuthor(author);
        this.setPath(path);
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public void setPath(String Path) {
        this.path = Path;
    }

    @Override
    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public void setYearRelease(int year) {
        this.year = year;
    }

    @Override
    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public int getRating() {
        return this.rating;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }

    @Override
    public void show() {
        Desktop desk = Desktop.getDesktop();
        File fileItem = new File(this.getPath());
        try {
            desk.print(fileItem);
        }catch (IOException e) {
            System.out.println("Exceptie IOException ! ");
        }
    }

    @Override
    public String toString() {
        return this.getName() + ", " + this.getAuthor();
    }
}