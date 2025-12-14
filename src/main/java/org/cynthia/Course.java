package org.cynthia;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private List<Assignment> assignments;
    private List<Student> registeredStudents;
    private static int nextId = 1;

    /**
     * Checks if the total weight of all assignments equals 100%.
     * @return true if total weight == 100; otherwise false.
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0;
        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }
        return Math.abs(sum - 100.0) < 0.001;
    }

    /**
     * Registers a student for this course.
     * @param student the student to register
     * @return true if successful， false if already registered.
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) return false;

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        return true;
    }

    /**
     * Calculates each student's weighted average across all assignments.
     * @return an array of average scores for all students
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double total = 0;
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    total += score * assignment.getWeight() / 100.0;
                }
            }
            averages[i] = (int) Math.round(total);
        }
        return averages;
    }

    /**
     * Generates random scores for all assignments and students.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        calcStudentsAverage();
    }

    /**
     * Displays the course scores in a formatted table.
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");
        System.out.print("              ");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
        }
        System.out.println("Final Score");

        int[] avgs = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            System.out.printf("%-15s", s.getStudentName());
            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                System.out.printf("%-15s", score == null ? "-" : score.toString());
            }
            System.out.printf("%d%n", avgs[i]);
        }

        System.out.print("Average        ");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15.1f", assignment.calcAssignmentAvg());
        }
        System.out.println();
    }
}
