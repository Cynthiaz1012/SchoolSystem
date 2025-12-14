package org.cynthia;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Setter
@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private List<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("A%03d", nextId++);;
        this.assignmentName = assignmentName;
        this.weight = weight;
    }

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

    /**
     *  Generates random scores for each student in this assignment.
     */
    public void generateRandomScore() {
        Random rand = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int range = rand.nextInt(11);
            int score;

            if (range == 0) score = rand.nextInt(60);
            else if (range <= 2) score = 60 + rand.nextInt(10);
            else if (range <= 4) score = 70 + rand.nextInt(10);
            else if (range <= 8) score = 80 + rand.nextInt(10);
            else score = 90 + rand.nextInt(11);

            scores.set(i, score);
        }
    }
}
