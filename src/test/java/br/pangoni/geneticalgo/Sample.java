package br.pangoni.geneticalgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sample{

    public static void main(String[] args) {

        Evaluate<String> e = new Evaluate<String>();

        String result = e.eval(buildPopulation(), new SampleFitness(), new SampleOperations());

        System.out.println("==== Result ===");
        System.out.println(result);
    }

    private static List<String> buildPopulation() {
        List<String> result = new ArrayList<String>();
        Random random = new Random();

        for(int i =0 ; i < 100000; i++){
            char[] e = new char[8];
            for(int j=0; j < 8; j++){
                e[j] = (char)random.nextInt(256);
            }

            result.add(new String(e));
        }

        return  result;
    }
}