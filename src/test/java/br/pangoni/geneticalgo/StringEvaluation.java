package br.pangoni.geneticalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StringEvaluation {

	private static Character[] options = new Character[]{
			'a', 'b', 'c', 'd', 'e', 'f', 
			'g', 'h', 'i', 'j', 'k', 
			'l', 'm', 'n', 'o','p', 
			'q', 'r', 's', 't', 'u',
			'v', 'x', 'y', 'z', 'w', ' '};

	public static void main(String[] args){
		
		
		Evaluate<Character> ev = new Evaluate<Character>(new Fitness<Character>() {

			private final char[] sample = "brown lazy fox".toCharArray();
			private double p = 1 / 14.0;
			
			public float score(Character[] a) {
				float result  = 0;
				
				for(int i=0; i< a.length; i++) {
					result += a[i] == sample[i] ? p: 0;
				}
				
				return result;
			}

			public float maxScore() {
				// TODO Auto-generated method stub
				return 1.0f;
			}
			
		}, options	);
		
		Character[] result = ev.eval( generate());
		StringBuilder builder = new StringBuilder();
		for(Character c: result){
			builder.append(c);			
		}

		System.out.println( builder.toString());
	}
	
	public static List<Character[]> generate(){
		Random r = new Random();
		List<Character[]>  result = new ArrayList<Character[]>();
		
		for(int i=0; i < 14; i++){
			Character[] e = new Character[14];
			for(int j=0; j < 14; j++){
				e[j] = options[r.nextInt(options.length)];
				
				result.add(e);
			}
		}
		
		return result;
	}
	
}
