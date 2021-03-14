package com.company;

import javax.annotation.processing.SupportedSourceVersion;
import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

class School implements Comparable<School>{
     private String Name;
     private LinkedList<Student> preferences;
     private int rank;
     private int capacity;

     School(String Name, int rank,int capacity)
     {
         this.setName(Name);
         this.setRank(rank);
         this.setCapacity(capacity);
     }

    /**
     * Setter pentru capacitate
     * @param capacity
     */
     public void setCapacity(int capacity){
         this.capacity = capacity;
     }

    /**
     * Getter pentru capacitate .
     * @return int
     */
     public int getCapacity(){
         return this.capacity;
     }

    /**
     * Setter pentru rank
     * @param rank
     */
     public void setRank(int rank){
         this.rank = rank;
     }

    /**
     * Getter pentru rank
     * @return int
     */
     public int getRank(){
         return this.rank;
     }
    /**
     * Setter pentru Name
     * @param Name
     * @return void
     */
    public void setName(String Name)
     {
         this.Name = Name;
     }
    /**
     * Setter pentru preferences;
     * @param preferences
     */
     public void setPreferences(LinkedList<Student> preferences)
     {
         this.preferences = new LinkedList<>();
         this.preferences = preferences;
         Collections.sort(preferences);
     }

    /**
     * Getter pentru Name
     * @return String
     */
     public String getName(){
         return this.Name;
     }
    /**
     * Getter pentru lista de preferinte .
     * @return LinkedList<Student>
     */
     public LinkedList<Student> getPreferences(){
         return this.preferences;
     }

    /**
     * @return void
     */
    public void ShowPreferences()
    {
        System.out.print(this.getName() +  "-> ");
        for(Student student : preferences)
        {
            System.out.print(" " + student.getName());
        }
        System.out.println();
    }
    @Override
    public int compareTo(School school) {
        if(this.rank > school.getRank())
        {
            return  1;
        }else{
            if(this.rank < school.getRank())
            {
                return -1;
            }else {
                return 0;
            }
        }
    }
}
