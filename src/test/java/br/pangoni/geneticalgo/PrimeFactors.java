package br.pangoni.geneticalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrimeFactors {

	private static Integer[] options = new Integer[]{ 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};

	public static void main(String[] args){
		
		
		Evaluate<Integer> ev = new Evaluate<Integer>(new Fitness<Integer>() {

			
			public float score(Integer[] a) {	
				float result = 0;
						
				if(a[0] + a[1] + a[2] + a[3] == 17){
					result += 0.3;
				}
				
				if(a[0] < 17) result += 0.1;
				if(a[1] < 17) result += 0.1;
				if(a[2] < 17) result += 0.1;
				if(a[3] < 17) result += 0.1;
				
				if(a[0] < a[1]) result += 0.1;
				if(a[1] < a[2]) result += 0.1;
				if(a[2] < a[3]) result += 0.1;
				
				return result;
			}

			public float maxScore() {
				// TODO Auto-generated method stub
				return 1.0f;
			}
			
		}, options	);
		
		Integer[] result = ev.eval( generate() );

		for(Integer i: result){
			System.out.print( i + " " );			
		}

	}
	
	public static List<Integer[]> generate(){
		Random r = new Random();
		List<Integer[]>  result = new ArrayList<Integer[]>();
		
		for(int i=0; i < 256 * 256; i++){
			Integer[] e = new Integer[4];
			for(int j=0; j < 4; j++){
				e[j] = options[r.nextInt(options.length)];
				
				result.add(e);
			}
		}
		
		return result;
	}

}
