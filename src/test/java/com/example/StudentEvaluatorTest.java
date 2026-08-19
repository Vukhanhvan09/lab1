package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentEvaluatorTest {

    @Test
    void shouldReturnInvalidForNullScores() {
        assertEquals("INVALID", StudentEvaluator.evaluate(null));
    }

    @Test
    void shouldReturnInvalidForEmptyScores() {
        assertEquals("INVALID", StudentEvaluator.evaluate(new int[]{}));
    }

    @Test
    void shouldReturnInvalidForScoreBelowZero() {
        assertEquals(
                "INVALID",
                StudentEvaluator.evaluate(new int[]{90, -1, 80})
        );
    }

    @Test
    void shouldReturnInvalidForScoreAbove100() {
        assertEquals(
                "INVALID",
                StudentEvaluator.evaluate(new int[]{90, 101, 80})
        );
    }

    @Test
    void shouldReturnExcellentForHighAverageWithoutFailedSubjects() {
        assertEquals(
                "EXCELLENT",
                StudentEvaluator.evaluate(new int[]{90, 85, 88, 92})
        );
    }

    @Test
    void shouldReturnGoodForAverageAtLeast70WithOneFailedSubject() {
        assertEquals(
                "GOOD",
                StudentEvaluator.evaluate(new int[]{90, 80, 40})
        );
    }

    @Test
    void shouldReturnPassForAverageAtLeast50WithTwoFailedSubjects() {
        assertEquals(
                "PASS",
                StudentEvaluator.evaluate(new int[]{70, 60, 40, 30})
        );
    }

    @Test
    void shouldReturnFailWhenStudentDoesNotMeetPassCriteria() {
        assertEquals(
                "FAIL",
                StudentEvaluator.evaluate(new int[]{40, 45, 30})
        );
    }
        @Test
    void shouldCoverMixedPassedAndFailedSubjects() {
        int[] scores = {80, 40, 90, 30};

        assertEquals("PASS", StudentEvaluator.evaluate(scores));
    }

    @Test
    void shouldCoverMultipleIterationsWithAllPassedSubjects() {
        int[] scores = {90, 80, 70, 60};

        assertEquals("GOOD", StudentEvaluator.evaluate(scores));
    }

    @Test
    void shouldCoverMultipleFailedSubjectsAndFailResult() {
        int[] scores = {40, 30, 20, 10};

        assertEquals("FAIL", StudentEvaluator.evaluate(scores));
    }

    @Test
    void shouldCoverInvalidScoreAfterValidScore() {
        int[] scores = {80, 70, 101};

        assertEquals("INVALID", StudentEvaluator.evaluate(scores));
    }
}
