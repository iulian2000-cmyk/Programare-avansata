package com.company;

import java.util.Map;
import java.util.HashMap;
/**
 * @author : Isac Iulian-George
 */
 class Solution{
     private Map<Student,School> matches;
     private Problem problem;

    /**
     * Getter pentru problem
     * @return Problem
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * Setter pentru problem
     * @return void
     * @param problem
     */
     public void setProblem(Problem problem)
     {
         this.problem=problem;
     }

    /**
     * Constructor
     * @param problem
     */
     Solution (Problem problem)
     {
         this.setProblem(problem);
     }
     /**
      * Algoritm de rezolvare a problemei . 
      * @return void
      */
     public void solveProblem()
     {
         Map<Student,School> solution= new HashMap<>();
         int[][] accordability=new int[this.problem.getStudents().size()][this.problem.getSchools().size()];

         for(int index_stud=0;index_stud<this.problem.getStudents().size();index_stud++){
             for(int index_school=0;index_school<this.problem.getSchools().size();index_school++){
                 accordability[index_stud][index_school]=999999;
             }
         }
         int i=0, j=0, k=0;
         for(Student s : this.problem.getStudents()){
             for (School sc: this.problem.getStudentPreferences().get(s)){
                 for(School sch: this.problem.getSchools()) {
                     if(sch.getName().equals(sc.getName())){
                         accordability[i][k]=j;
                         break;
                     }
                     k++;
                 }
                 k=0;
                 j++;
             }
             j=0;
             i++;
         }
         i=j=k=0;
         for(School sc:this.problem.getSchools()){
             for (Student s: this.problem.getStudents()) {
                 for (Student st: this.problem.getStudents()){
                     if(st.equals(s)){
                         if(accordability[k][i]!=999999)
                             accordability[k][i]+=j;
                     }
                     k++;
                 }
                 k=0;
                 j++;
             }
             j=0;
             i++;
         }
         int minj=-1, mini=-1,min=0;
         boolean[] columnDoneFinished=new boolean[this.problem.getSchools().size()];
         boolean[] rowDoneFinished=new boolean[this.problem.getStudents().size()];
         while(min!=999999){
             min=999999;
             //cautam minimul
             for(i=0;i<this.problem.getStudents().size();i++)
                 for(j=0;j<this.problem.getSchools().size();j++)
                     if(!rowDoneFinished[i]&&!columnDoneFinished[j]){
                         if(accordability[i][j]<min){
                             minj=j;
                             mini=i;
                             min=accordability[i][j];
                         }
                     }
             if(min!=999999){
                 solution.put(this.problem.getStudents().get(mini),this.problem.getSchools().get(minj));
                 rowDoneFinished[mini]=true;
                 this.problem.getCapacity()[minj]--;
                 if(this.problem.getCapacity()[minj]==0)
                     columnDoneFinished[minj]=true;
             }
         }
         matches = solution;
     }

    /**
     * Metoda folosita pentru a printa solutia la o problema
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder temp= new StringBuilder("  solution:\n");
        for (Student s: matches.keySet())
            temp.append(s.getName()).append("    :     ").append(matches.get(s).getName()).append("\n");
        return temp.toString();
    }
}
