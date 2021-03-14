package com.company;


import java.util.*;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

class Solution {
     private Problem problemToResolve;
     private LinkedHashMap<Student,School> listOfPairs;

    Solution(Problem problem) {
        this.setProblemToResolve(problem);
     }

     /**
      * Setter pentru problema
      * @return void
      * @param problem
      */
     public void setProblemToResolve(Problem problem)
     {
         this.problemToResolve = problem;
     }

     /**
      * Getter pentru problem
      * @return Problem
      */
     public Problem getProblemToResolve()
     {
         return this.problemToResolve;
     }


}
