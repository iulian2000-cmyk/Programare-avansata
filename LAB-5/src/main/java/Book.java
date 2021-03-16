import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;


class Book extends Item implements Serializable {
    private String Name;
    private int year;
    private int rating;
    private String author;
    private String path;

    Book(String Name,int year,int rating,String author,String Path)
    {
        this.setAuthor(author);
        this.setName(Name);
        this.setRating(rating);
        this.setYearRelease(year);
        this.setPath(Path);
    }




    public void setYearRelease(int year) {
        this.year = year;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public void setAuthor(String author) {
        this.author = author;
    }


    public int getYear() {
        return this.year;
    }


    public int getRating() {
        return this.rating;
    }


    public String getAuthor() {
        return this.author;
    }


    public String toString() {
        return this.getName() + ", " + this.getAuthor();
    }
}