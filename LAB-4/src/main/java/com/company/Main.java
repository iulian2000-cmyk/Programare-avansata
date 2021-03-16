package com.company;

import java.util.*;
import java.util.stream.Stream;
import com.github.javafaker.Faker;

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

        // Optional

        Random rand = new Random();
        int [] capacity = {1,2,2};
        Problem problem = new Problem(studentPreferences,schoolPreferences,capacity);
        LinkedList<School> schoolsToSearch = new LinkedList<>();
        schools.stream()
                .filter( school -> school.getName().equals("H0")||school.getName().equals("H1"))
                .forEach (schoolsToSearch::add);
        /*
        for(School school : schoolsToSearch)
        {
            System.out.println(school.getName());
        }
        */
        // Determinam studentii care au ca si preferinte H0 si H1


        students.stream()
                .filter(student -> studentPreferences.get(student).containsAll(schoolsToSearch));

        // Printam scolile care au ca si prima preferinta S0
        System.out.print("Schools with S0 top preference : ");
        schools.stream()
                .filter(school -> schoolPreferences.get(school).get(0).equals(students.get(0)))
                .forEach(each -> System.out.print(each.getName()+ ","));
        // Generare solutie problema initiala
        Solution solution = new Solution(problem);
        solution.solveProblem();
        System.out.println("\n Initial problem" + solution.toString());

        int numberStudents = rand.nextInt(100);
        int numberSchools = rand.nextInt(100);
        int [] capacity_schools = new int [numberSchools];

        for(int index = 0;index<numberSchools;index++)
        {
             capacity_schools[index] = rand.nextInt(100);
        }
        Faker faker = new Faker();
        List<School> schools_faker = new LinkedList<>();
        List<Student> students_faker = new LinkedList<>();

        // Generam nume fake pentru studenti si licee , dar si capacitati random , note random
        for(int indexListStudent=0;indexListStudent < numberStudents;indexListStudent++)
        {
            students_faker.add(new Student(faker.name().username(),rand.nextInt(10)));
        }
        for(int indexListSchools = 0 ;indexListSchools < numberSchools;indexListSchools++)
        {
            schools_faker.add(new School(faker.university().name(),capacity_schools[indexListSchools]));
        }
        Map<Student,Set<School>> studentFakerPreferences = new HashMap<>();
        for(Student student : students_faker)
        {
            Set<School> preferencesForStudent = new TreeSet<>();
            int numberPreferencesForThisStudent = rand.nextInt(numberSchools);
            for(int i=1;i<numberPreferencesForThisStudent;i++)
            {
                preferencesForStudent.add(schools_faker.get(rand.nextInt(schools_faker.size())));
            }
            studentFakerPreferences.put(student,preferencesForStudent);
        }
        Map<School,List<Student>> schoolFakerPreferences = new HashMap<>();
        for(School school : schools_faker)
        {
            List<Student>preferencesForThisSchool = new LinkedList<>();
            int numberPreferencesForThisSchool = rand.nextInt(numberStudents);
            for(int i=1;i<numberPreferencesForThisSchool;i++)
            {
                preferencesForThisSchool.add(students_faker.get(rand.nextInt(students_faker.size())));
            }
            schoolFakerPreferences.put(school,preferencesForThisSchool);
        }
        Problem problemOptional = new Problem(studentFakerPreferences,schoolFakerPreferences,capacity_schools);
        Solution solutionOptional = new Solution(problemOptional);
        solutionOptional.solveProblem();
        System.out.println("Problem with fake dates " + solutionOptional.toString());

    }
}


