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
}
