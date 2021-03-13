

class Book extends Item{
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
}
