package com.company;

import javax.swing.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Compulsory
        // Crearea obiectelor folosind stream-uri .
        Stream<Student> streamStudents = Stream.<Student>builder().add(new Student("S0",10)).add(new Student("S1",8)).add(new Student("S2",8)).add(new Student("S3",7)).build();
        Stream<School> streamSchools = Stream.of(new School("H0", 1), (new School("H1", 2)), (new School("H2", 2)));

        // LinkedList pentru studenti
        LinkedList<Student> students= new LinkedList<>();
        streamStudents.forEach(students::add);
        // Sortare bazata pe scorul studentului
        students.sort(Comparator.comparing(Student::getScore));
        // TreeSet pentru scoli
        Set<School> schools= new TreeSet<>();
        streamSchools.forEach(schools::add);

        // Afisarea listelor de scoli , studenti
        /*
        for(Student student : students)
        {
            System.out.println(student.getName() + "  " +  student.getScore());
        }
        for (School school : schools)
        {
            System.out.println(school.getName() + "  " + school.getCapacity());
        }
         */
        // Afisarea preferintelor pt fiecare student in parte
        Map<Student,Set<School>> studentPreferences=new HashMap<>();
        studentPreferences.put(new Student("S0",10),schools);
        studentPreferences.put(new Student("S1",8),schools);

        Set<School> schools_for_S2 = new TreeSet<>();
        schools_for_S2.add(new School("H0",1));
        schools_for_S2.add(new School("H1",2));

        studentPreferences.put(students.get(2),schools_for_S2);
        Set<School> schools_for_S3 = new TreeSet<>();
        schools_for_S3.add(new School("H0",1));
        schools_for_S3.add(new School("H2",2));

        studentPreferences.put(new Student("S3",7),schools_for_S3);
        for(Student student : studentPreferences.keySet())
        {
            System.out.print("  " + student.getName() + "->");
            for(School school : studentPreferences.get(student))
            {
                System.out.print(" " + school.getName());
            }
            System.out.println();
        }
        // Afisarea preferintelor pentru fiecare scoala in parte
        Map<School,List<Student>>schoolPreferences=new TreeMap<>();
        Iterator<School> iteratorForSchools = schools.iterator();
        School iteratorValueForSchools=iteratorForSchools.next();
        schoolPreferences.put(iteratorValueForSchools,new LinkedList<>());
        schoolPreferences.get(iteratorValueForSchools).add(students.get(3));
        schoolPreferences.get(iteratorValueForSchools).add(students.get(0));
        schoolPreferences.get(iteratorValueForSchools).add(students.get(1));
        schoolPreferences.get(iteratorValueForSchools).add(students.get(2));
        iteratorValueForSchools=iteratorForSchools.next();
        schoolPreferences.put(iteratorValueForSchools,new LinkedList<>());
        schoolPreferences.get(iteratorValueForSchools).add(students.get(0));
        schoolPreferences.get(iteratorValueForSchools).add(students.get(2));
        schoolPreferences.get(iteratorValueForSchools).add(students.get(1));
        iteratorValueForSchools=iteratorForSchools.next();
        schoolPreferences.put(iteratorValueForSchools,new LinkedList<>());
        schoolPreferences.get(iteratorValueForSchools).add(students.get(0));
        schoolPreferences.get(iteratorValueForSchools).add(students.get(1));
        schoolPreferences.get(iteratorValueForSchools).add(students.get(3));
        for (School s : schoolPreferences.keySet()){
            System.out.print(s.getName()+" :( ");
            schoolPreferences.get(s).forEach(each -> System.out.print(each.getName()+" "));
            System.out.print(")\n");
        }
    }
}
