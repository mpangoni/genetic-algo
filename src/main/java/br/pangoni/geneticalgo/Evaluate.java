package br.pangoni.geneticalgo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Evaluate<T> {

    private T[] options;
    private Fitness<T> fitness;
    
    private Random random = new Random();
    private long generationCounter = 0;
    
    private float crossoverRate = 0.5f;
    private float mutationRate = 0.015f;
    private float selectionRate= 0.03f;

    public Evaluate(Fitness<T> fitness, T[] options){
    	this.fitness = fitness;
    	this.options = options;
    }
    
    public T[] eval(List<T[]> population){
    	
    	List<T[]> generation = population;
    	T[] best = generation.get(0);
    	
    	while( fitness.score(best) < fitness.maxScore() ){
    		
    		generation = generate(generation);
    		
    		generation.sort(new Comparator<T[]>() {

				public int compare(T[] a, T[] b) {
					return (int) ((fitness.score(b) - fitness.score(a)) * 100);
				}
    			
			});
    		
    		best = generation.get(0);
    		System.out.println(String.format("genration: %d score: %f - %s", generationCounter++, fitness.score(best), best) );
    	}
    	
    	return best;
    }
    
    protected List<T[]> generate( List<T[]> population ){

    	List<T[]> result = new ArrayList<T[]>();
    	
    	for(int i=0; i < population.size(); i++){

    		T[] a = selection(population);
    		T[] b = selection(population);
    		
    		T[] c = crossover(a, b);
    		
    		mutate(c);
    		
    		result.add( c );
    		
    	}
		
		return result;

    }
    
    protected T[] crossover(T[] a, T[]b){

    	assert a != null;
    	assert b != null;
    	
    	T[] result = (T[])Array.newInstance(a[0].getClass(), a.length);
    	
    	assert result != null;
    	for(int i = 0; i < a.length; i++){
    		result[i] = random.nextDouble() < crossoverRate ? a[i] : b[i];
    	}
    	
    	return result;
    }
    
    protected void mutate(T[] a) {
    	
    	for(int i = 0; i < a.length; i++){
    		
    		if(random.nextDouble() < mutationRate) {
    			int optionsIndex = random.nextInt( options.length );
    			a[i] = options[ optionsIndex ]; 
    		}
    	}    	
    }
    
    protected T[] selection(List<T[]> population) {
    	T[] selected = null;
    	float selectedScore = Float.NEGATIVE_INFINITY;
    	
    	for(int i =0; i < (population.size() * selectionRate); i++){
    		T[] current = population.get(random.nextInt( population.size() ));
    		float currentScore = fitness.score(current);
    		
    		if(currentScore > selectedScore){
    			selected = current;
    			selectedScore = currentScore;
    		}
    	}
    	
    	assert selected != null;

    	return selected;
    }
}