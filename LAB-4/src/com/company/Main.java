package com.company;
import com.sun.source.tree.Tree;

import java.util.*;
import java.util.stream.*;
public class Main {


    public static void main(String[] args) {
        // Crearea obiectelor de tipul Student

        Student S0 = new Student("S0",12.1);
        Student S1 = new Student("S1",11);
        Student S2 = new Student("S2",10);
        Student S3 = new Student("S3",19);

        // Crearea obiectelor de tipul School
        School H0 = new School("H0",1,1);
        School H1 = new School("H1",2,2);
        School H2 = new School("H2",3,2);

        System.out.println("\nPreferences for each student . ");
        TreeSet<School> preferencesStudents = new TreeSet<School>();
        preferencesStudents.add(H0);
        preferencesStudents.add(H1);
        preferencesStudents.add(H2);

        S0.setPreferences(preferencesStudents);
        S0.showPreferences();
        S1.setPreferences(preferencesStudents);
        S1.showPreferences();
        preferencesStudents.clear();
        preferencesStudents.add(H0);
        preferencesStudents.add(H1);

        S2.setPreferences(preferencesStudents);
        S2.showPreferences();
        preferencesStudents.clear();
        preferencesStudents.add(H0);
        preferencesStudents.add(H2);

        S3.setPreferences(preferencesStudents);
        S3.showPreferences();
        preferencesStudents.clear();

        preferencesStudents.add(H0);
        preferencesStudents.add(H1);
        preferencesStudents.add(H2);

        // Hash map pentru studenti
        HashMap<Student,TreeSet<School>> hashMapForStudents = new HashMap<>();
        hashMapForStudents.put(S0,S1.getPreferences());
        hashMapForStudents.put(S1,S0.getPreferences());
        hashMapForStudents.put(S2,S2.getPreferences());
        hashMapForStudents.put(S3,S3.getPreferences());

        System.out.println("\n Preferences for schools : ");
        LinkedList<Student> linkedListStudents = new LinkedList<>();

        linkedListStudents.add(S3);
        linkedListStudents.add(S0);
        linkedListStudents.add(S1);
        linkedListStudents.add(S2);
        H0.setPreferences(linkedListStudents);
        H0.ShowPreferences();

        linkedListStudents.clear();
        linkedListStudents.add(S0);
        linkedListStudents.add(S1);
        linkedListStudents.add(S2);

        H1.setPreferences(linkedListStudents);
        H1.ShowPreferences();

        linkedListStudents.clear();
        linkedListStudents.add(S0);
        linkedListStudents.add(S1);
        linkedListStudents.add(S3);
        H2.setPreferences(linkedListStudents);
        H2.ShowPreferences();

        HashMap<School,LinkedList<Student>> hashMapForSchools = new HashMap<>();
        hashMapForSchools.put(H0,H0.getPreferences());
        hashMapForSchools.put(H1,H1.getPreferences());
        hashMapForSchools.put(H2,H2.getPreferences());

        // Creare streeam-uri
        Stream <Student> streamStudents = linkedListStudents.stream();
        Stream <School> streamSchools = preferencesStudents.stream();
        long numberStudents = streamStudents.count();
        long numberSchools = streamSchools.count();



    }
}