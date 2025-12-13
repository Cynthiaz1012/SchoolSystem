package org.cynthia;

import java.util.List;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    /**
     * Calculates and returns the average score of this assignment.
     * @return the average score
     */
    public double calcAssignmentAvg() {
        if (scores == null || scores.isEmpty()) return 0.0;

        double total = 0;
        int count = 0;
        for (Integer score : scores) {
            if (score != null) {
                total += score;
                count++;
            }
        }
        return count == 0 ? 0.0 : total / count;
    }
}
