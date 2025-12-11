package org.cynthia;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private List<Course> registeredCourses;
    private static int nextId = 1;

    /**
     * generate the id for the next department
     * @return the id for the next department
     */
    private static String generateId(){
        return String.format("S%06d", nextId++);
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = studentName;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Registers this student for a given course.
     * @param course the course to register
     * @return  true if registration succeeded; false if already registered
     */
    public boolean registerCourse(Course course) {
        if (course == null) return false;

        if (registeredCourses.contains(course)) {
            return false; // already registered
        }

        registeredCourses.add(course);

        if (!course.getRegisteredStudents().contains(this)) {
            course.getRegisteredStudents().add(this);
        }

        for (Assignment a : course.getAssignments()) {
            a.getScores().add(null);
        }

        return true;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
