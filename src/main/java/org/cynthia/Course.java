package org.cynthia;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

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
            Student student = registeredStudents.get(i);
            System.out.printf("%-15s", student.getStudentName());
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
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

    /**
     *  Adds a new assignment to the course.
     * @param assignmentName the assignment name
     * @param weight the weight of the assignment
     * @return always true
     */
    public boolean addAssignment(String assignmentName, double weight) {
        Assignment newAssignment = new Assignment(assignmentName, weight);
        for (int i = 0; i < registeredStudents.size(); i++) {
            newAssignment.getScores().add(null);
        }
        assignments.add(newAssignment);
        return true;
    }

    /**
     * Returns a simplified string representation of the course.
     * @return simple formatted string
     */
    public String toSimplifiedString() {
        return courseId + " - " + courseName + " (" + credits + " credits, " +
                department.getDepartmentName() + ")";
    }

    /**
     * Converts this Course object into a formatted string representation.
     * @return a formatted string containing the course's details, assignments, registered students, and weight validity information.
     */
    public String toString() {
        String result = "Course ID: " + courseId
                + "\nCourse Name: " + courseName
                + "\nCredits: " + credits
                + "\nDepartment: " + department.getDepartmentName()
                + "\nAssignments:";

        if (assignments.isEmpty()) {
            result += " None";
        } else {
            for (Assignment assignment : assignments) {
                result += "\n  " + assignment.getAssignmentId()
                        + " - " + assignment.getAssignmentName()
                        + " (" + assignment.getWeight() + "%)";
            }
        }

        result += "\nRegistered Students:";
        if (registeredStudents.isEmpty()) {
            result += " None";
        } else {
            for (Student student : registeredStudents) {
                result += "\n  " + student.getStudentId()
                        + " - " + student.getStudentName()
                        + " (" + (student.getDepartment() != null ? student.getDepartment().getDepartmentName() : "No Department") + ")";
            }
        }
        result += "\nAssignment Weights Valid: " + (isAssignmentWeightValid() ? "Yes" : "No");
        return result;
    }
}
