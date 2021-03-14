package com.company;
import com.sun.source.tree.Tree;

import java.util.TreeSet;


class Student implements Comparable<Student> {
    private String Name;
    private double score;
    private TreeSet<School> preferences;

    /**
     * Setter pentru preferinte
     * @param preferences
     */
    public void setPreferences(TreeSet<School> preferences)
    {
       this.preferences = new TreeSet<>();
       this.preferences = preferences;
    }

    /**
     * Getter pentru preferinte .
     * @return TreeSet<Student>
     */
    public TreeSet<School> getPreferences()
    {
        return this.preferences;
    }
    /**
     * Constructor Student()
     */
    Student(String Name,double score)
    {
        this.setName(Name);
        this.setScore(score);
    }
    /**
     * Setter pentru nume
     * @param Name
     * @return void
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    /**
     * Setter pentru mark
     * @param score
     * @return void
     */
    public void setScore(double score)
    {
        this.score=score;
    }

    /**
     * Getter pentru nume
     * @return String
     */
    public String getName()
    {
        return this.Name;
    }
    /**
     * Getter pentru mark
     * @return double
     */
    public double getScore(){
        return this.score;
    }

    @Override
    public int compareTo(Student student) {
        if(this.score > student.getScore() )
        {
            return 1;
        }else{
            if(this.score < student.getScore())
            {
                return -1;
            }else{
                return 0;
            }
        }
    }
    /**
     * Functie de afisare
     * @return void
     */
    public void showPreferences(){
        System.out.print(this.getName() +  "->");
        for(School value : preferences) {
            System.out.print("  " + value.getName());
        }
        System.out.println();
    }
}
