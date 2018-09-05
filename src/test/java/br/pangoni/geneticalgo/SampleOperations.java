package br.pangoni.geneticalgo;

import java.util.Random;

public class SampleOperations implements Operations<String>{

    private Random random = new Random();

	public String crossover(String a, String b) {

        StringBuilder result = new StringBuilder();

        for(int i=0; i < a.length(); i++) {
            result.append( random.nextBoolean() ? a.charAt(i) : b.charAt(i));
        }

        System.out.println(result);
        return result.toString();
	}

	public String mutate(String e) {

		if(random.nextDouble() < 0.25) {
            StringBuffer buffer = new StringBuffer(e);
            char c = (char)random.nextInt(256);
            int i = random.nextInt(e.length());

            buffer.setCharAt(i, c);

            return buffer.toString();
        }

        return e;
	}

}