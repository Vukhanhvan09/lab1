package com.example;

public class Main {

    public static void main(String[] args) {

        int[] scores = {90, 85, 88, 92};

        String result = StudentEvaluator.evaluate(scores);

        System.out.println("Result: " + result);
    }
}