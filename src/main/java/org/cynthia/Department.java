package org.cynthia;


public class Department {
    private final String id;
    private String departmentId;
    private String departmentName;

    public static int nextId = 1;

    /**
     * generate the id for the next department
     * @return the id for the next department
     */
    private static String generateId(){
        return String.format("%02d", nextId++);
    }

}
