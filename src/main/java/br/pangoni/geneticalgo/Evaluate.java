package br.pangoni.geneticalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Evaluate<T> {

    private Random random = new Random();
    private float selectionScore =  0.5f;

    public T eval(List<T> population, Fitness<T> fitness, Operations<T> operations){
       
        List<T> lastOnes = population;
        List<T> nextOnes = new ArrayList<T>();

        for(T e : lastOnes){
            
            float score = fitness.score(e);

            if(score > 0.99) {
                return e;                
            }
            
            if(score > this.selectionScore ) {
                nextOnes.add(e);
            }
            
        }

        for(T e : nextOnes) { 

            int i = this.random.nextInt(selecteds.size()); 
           
            T c = operations.crossover(e, selecteds.get(i));

            c = operations.mutate(c);
            
        }
        
        return eval(selecteds, fitness, operations);
    }

}