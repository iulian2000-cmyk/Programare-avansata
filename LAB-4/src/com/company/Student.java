package com.company;

/**
 * @author Isac Iulian-George
 *
 */
class Student {
    private String Name;
    private double score;
    Student(String name,double score){
        this.setScore(score);
        this.setName(name);
    }

    /**
     * Getter pentru score
     * @return double
     */
    public double getScore()
    {
        return this.score;
    }
    /**
     * Setter pentru scor
     * @return void
     * @param score
     */
    public void setScore(double score)
    {
        this.score = score;
    }
    /**
     * Setter pentru nume
     * @return void
     * @param Name
     */
   public void setName(String Name)
   {
       this.Name = Name;
   }
    /**
     * Getter pentru name
     * @return String
     */
    public String getName() {
        return this.Name;
    }
}
