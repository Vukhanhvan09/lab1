package com.example;

public class StudentEvaluator {

    public static String evaluate(int[] scores) {

        if (scores == null || scores.length == 0) {
            return "INVALID";
        }

        int total = 0;
        int passedSubjects = 0;
        int failedSubjects = 0;

        for (int score : scores) {

            if (score < 0 || score > 100) {
                return "INVALID";
            }

            total += score;

            if (score >= 50) {
                passedSubjects++;
            } else {
                failedSubjects++;
            }
        }

        double average = (double) total / scores.length;

        if (average >= 85 && failedSubjects == 0) {
            return "EXCELLENT";
        } else if (average >= 70 && failedSubjects <= 1) {
            return "GOOD";
        } else if (average >= 50 && failedSubjects <= 2) {
            return "PASS";
        } else {
            return "FAIL";
        }
    }
}