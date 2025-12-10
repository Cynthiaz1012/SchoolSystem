package org.cynthia;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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

    public enum Gender {
        MALE, FEMALE
    }
}
