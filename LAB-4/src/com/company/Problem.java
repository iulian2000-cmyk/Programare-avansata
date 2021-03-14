package com.company;

import java.util.LinkedList;

class Problem {
    private LinkedList<Student> students;
    private LinkedList<School> schools;

    /**
     * Constructor
     * @param students
     * @param schools
     */
    Problem(LinkedList<Student> students,LinkedList<School> schools){
       this.setStudents(students);
       this.setSchools(schools);
    }

    /**
     * Setter pentru lista de studenti
     * @return void
     * @param students
     */
    public void setStudents(LinkedList<Student> students)
    {
        this.students = new LinkedList<>();
        this.students = students;
    }

    /**
     * Getter pentru lista de studenti
     * @return LinkedList<Student>
     */
    public LinkedList<Student> getStudents(){
        return this.students;
    }

    /**
     * Setter pentru lista de scoli
     * @param schools
     */
    public void setSchools(LinkedList<School> schools)
    {
        this.schools = new LinkedList<>();
        this.schools = schools;
    }

    /**
     * Getter pentru lista de scoli
     * @return LinkedList<School>
     */
    public LinkedList<School> getSchools()
    {
        return this.schools;
    }

}
