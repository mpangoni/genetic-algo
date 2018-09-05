package br.pangoni.geneticalgo;

public interface Operations<T> {

    public T crossover(T a, T b);

    public T mutate(T e);

}