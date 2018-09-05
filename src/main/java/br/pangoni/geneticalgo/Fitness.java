package br.pangoni.geneticalgo;

public interface Fitness<T> {

    public float score(T e);

}