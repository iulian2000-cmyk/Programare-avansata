

abstract  class Item {

    /**
     * Geter pentru cale
     * @return
     */
    abstract public String getPath();
    /**
     * Setter pentru cale
     * @param Path
     */
    abstract public void setPath(String Path);
    /**
     * Setter pentru nume
     * @param Name
     */
    abstract public void setName(String Name);

    /**
     * Setter pentru anul lansarii
     * @param year
     */
    abstract public void setYearRelease(int year);

    /**
     * Setter pentru rating
     * @param rating
     */
    abstract public void setRating(int rating);

    /**
     * Setter pentru numele autorului
     * @param author
     */
    abstract public void setAuthor (String author);

    /**
     * Getter pentru nume
     * @return String
     */
    abstract public String getName();

    /**
     * Getter pentru anul lansarii
     * @return int
     */
    abstract public int getYear();

    /**
     * Getter pentru rating
     * @return
     */
    abstract public int getRating();

    /**
     * Getter pentru numele autorului .
     * @return String
     */
    abstract public String getAuthor();
}
