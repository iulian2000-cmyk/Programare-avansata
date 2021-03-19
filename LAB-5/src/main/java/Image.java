import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

class Image extends Item implements Serializable {
    private int year;
    private int rating;
    private String author;
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

    public void setYearRelease(int year) {
        this.year = year;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public void setAuthor(String author)
    {
        this.author = author;
    }


    public int getYear()
    {
        return this.year;
    }


    public int getRating()
    {
        return this.rating;
    }

    public String getAuthor()
    {
        return this.author;
    }
    public String toString()
    {
        return this.getName() + ", " + this.getAuthor();
    }
}