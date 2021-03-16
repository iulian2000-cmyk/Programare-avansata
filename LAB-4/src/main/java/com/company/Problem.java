package com.company;


import java.util.*;

/**
 * @author : Isac Iulian-George
 *
 */
class Problem {

    private Map<Student, Set<School>> studentPreferences;
    private Map<School, List<Student>> schoolPreferences;
    private List<Student> students = new ArrayList<>();
    private List<School> schools = new ArrayList<>();
    private int[] capacity;

    /**
     * Constructor
     *
     * @param studentPreferences
     * @param schoolPreferences
     * @param capacity
     */
    Problem(Map<Student, Set<School>> studentPreferences, Map<School, List<Student>> schoolPreferences, int[] capacity) {
        this.setStudentPreferences(studentPreferences);
        this.setSchoolPreferences(schoolPreferences);
        students.addAll(this.studentPreferences.keySet());
        schools.addAll(this.schoolPreferences.keySet());
        this.setCapacity(capacity);
    }

    /**
     * Getter pentru preferintele scolilor
     * @return Map<School,List<Student>>
     */
    public Map<School,List<Student>> getSchoolPreferences(){
        return this.schoolPreferences;
    }
    /**
     * Getter pentru preferintele studentilor
     * @return Map<Student,Set<School>>
     */
     public Map<Student,Set<School>> getStudentPreferences()
     {
         return this.studentPreferences;
     }
    /**
     * Setter pentru preferintele scolilor
     * @return void
     * @param preferences
     */
    public void setSchoolPreferences(Map<School,List<Student>> preferences)
    {
        this.schoolPreferences = preferences;
    }
    /**
     * Setter pentru preferintele studentilor
     *
     * @param preferences
     * @return void
     */
    public void setStudentPreferences(Map<Student, Set<School>> preferences) {
        this.studentPreferences = preferences;
    }

    /**
     * Getter pentru lista de scoli
     * @return List<School>
     */
   public List<School> getSchools()
   {
       return this.schools;
   }
    /**
     * Getter pentru lista de studenti
     * @return List<Student>
     */
    public List<Student> getStudents(){
        return this.students;
    }
    /**
     * Setter capacity
     *
     * @param capacity
     * @return void
     */
    public void setCapacity(int[] capacity) {
        this.capacity = capacity;
    }
    /**
     * @return int []
     */
    public int [] getCapacity()
    {
        return this.capacity;
    }
}
