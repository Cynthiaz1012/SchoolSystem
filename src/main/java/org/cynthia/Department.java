package org.cynthia;


public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * generate the id for the next department
     * @return the id for the next department
     */
    private static String generateId(){
        return String.format("D%02d", nextId++);
    }

    /**
     * Checks whether a department name is valid.
     * @param departmentName the department name to check
     * @return true if valid, false otherwise
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }
        for (int i = 0; i < departmentName.length(); i++) {
            char c = departmentName.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

}
