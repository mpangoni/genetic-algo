package br.pangoni.geneticalgo;

public interface Fitness<T> {
	
	public float score(T[] a);
	
	public float maxScore();
	
}