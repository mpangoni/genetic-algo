package br.pangoni.geneticalgo;

public class SampleFitness implements Fitness<String> {

    private static String sample = "TrustNo1";

	public float score(String e) {
        float result  = 0;

        if(e.length() != sample.length()) {
            for(int i=0; i < sample.length(); i++) {
                result += e.charAt(i) == sample.charAt(i) ? 0.125: 0;
            }    
        }

        return result;
	}
}