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
            return false;
        }

        registeredCourses.add(course);

        if (!course.getRegisteredStudents().contains(this)) {
            course.getRegisteredStudents().add(this);
        }

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }
        return true;
    }

    /**
     * Drops a course from this student's registered list.
     * @param course the course to drop
     * @return true if successfully dropped, false otherwise.
     */
    public boolean dropCourse(Course course) {
        if (course == null) return false;

        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);
        return true;
    }

    /**
     * Converts this Student object into a simplified string representation.
     * @return a string containing the studentId, studentName, and departmentName.
     */
    public String toSimplifiedString() {
        return studentId + " - " + studentName
                + " (" + (department != null ? department.getDepartmentName() : "No Department") + ")";
    }

    /**
     * Converts this Student object into a detailed string representation.
     * @return  a formatted string containing full student details
     */
    public String toString() {
        String result = "Student ID: " + studentId
                + "\nName: " + studentName
                + "\nGender: " + gender
                + "\nAddress: " + address
                + "\nDepartment: " + department;

        if (registeredCourses.isEmpty()) {
            result += "\nRegistered Courses: None";
        } else {
            result += "\nRegistered Courses:";
            for (Course course : registeredCourses) {
                result += "\n  - " + course.getCourseId()
                        + " (" + course.getCourseName() + ") in "
                        + course.getDepartment().getDepartmentName();
            }
        }
        return result;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
