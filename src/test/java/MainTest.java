import org.cynthia.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MainTest {
    @Test
    @DisplayName("H3E1L4 -> true")
    void testIsPostalCodeValid1() {
        String postalCode = "H3E1L4";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("123456 -> true")
    void testIsPostalCodeValid2() {
        String postalCode = "123456";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void testIsPostalCodeValid3() {
        String postalCode = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("3L4L1 -> false")
    void testIsPostalCodeValid4() {
        String postalCode = "3L4L1";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Computer Science And Math -> true")
    void testisDepartmentNameValid1() {
        String departmentName = "Computer Science And Math";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void testisDepartmentNameValid2() {
        String departmentName = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("empty -> false")
    void testisDepartmentNameValid3() {
        String departmentName = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("12345 -> false")
    void testisDepartmentNameValid4() {
        String departmentName = "12345";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("normal register -> true")
    void testRegisterCourse1() {
        Student student = new Student("Jane Doe", Student.Gender.FEMALE,
                new Address(11, "Terry", "Montreal", Address.Province.QC, "H3E1L4"),
                new Department("Computer Science"));
        Course course = new Course("Programming", 3.0, new Department("Computer Science"));
        boolean expected = true;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register again -> false")
    void testRegisterCourse2() {
        Student student = new Student("Jane Doe", Student.Gender.FEMALE,
                new Address(11, "Terry", "Montreal", Address.Province.QC, "H3E1L4"),
                new Department("Computer Science"));
        Course course = new Course("Programming", 3.0, new Department("Computer Science"));
        student.registerCourse(course);
        boolean expected = false;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("course = null -> false")
    void testRegisterCourse3() {
        Student student = new Student("Jane Doe", Student.Gender.FEMALE,
                new Address(11, "Terry", "Montreal", Address.Province.QC, "H3E1L4"),
                new Department("Computer Science"));
        Course course = null;
        boolean expected = false;
        boolean actual = student.registerCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("normal drop -> true")
    void testDropCourse1() {
        Student student = new Student("Jane Doe", Student.Gender.FEMALE,
                new Address(11, "Terry", "Montreal", Address.Province.QC, "H3E1L4"),
                new Department("Computer Science"));
        Course course = new Course("Programming", 3.0, new Department("Computer Science"));
        student.registerCourse(course);
        boolean expected = true;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("drop no register course -> false")
    void testDropCourse2() {
        Student student = new Student("Jane Doe", Student.Gender.FEMALE,
                new Address(11, "Terry", "Montreal", Address.Province.QC, "H3E1L4"),
                new Department("Computer Science"));
        Course course = new Course("Programming", 3.0, new Department("Computer Science"));
        boolean expected = false;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void testDropCourse3() {
        Student student = new Student("Jane Doe", Student.Gender.FEMALE,
                new Address(11, "Terry", "Montreal", Address.Province.QC, "H3E1L4"),
                new Department("Computer Science"));
        Course course = null;
        boolean expected = false;
        boolean actual = student.dropCourse(course);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("80, 90, 70 -> 80.0")
    void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Lab 1", 40);
        assignment.setScores(Arrays.asList(80, 90, 70));
        double expected = 80.0;
        double actual = assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("null -> 0.0")
    void testCalcAssignmentAvg2() {
        Assignment assignment = new Assignment("Lab 1", 40);
        assignment.setScores(Arrays.asList(null, null, null));
        double expected = 0.0;
        double actual = assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("80, null, 100 -> 90.0")
    void testCalcAssignmentAvg3() {
        Assignment assignment = new Assignment("Lab 1", 40);
        assignment.setScores(Arrays.asList(80, null, 100));
        double expected = 90.0;
        double actual = assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("{} -> 0.0")
    void testCalcAssignmentAvg4() {
        Assignment assignment = new Assignment("Lab 1", 40);
        assignment.setScores(Arrays.asList());
        double expected = 0.0;
        double actual = assignment.calcAssignmentAvg();
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    @DisplayName("40 + 60 -> true")
    void testIsAssignmentWeightValid1() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        course.addAssignment("Lab 1", 40);
        course.addAssignment("Lab 2", 60);
        boolean expected = true;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("40 + 30 -> false")
    void testIsAssignmentWeightValid2() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        course.addAssignment("Lab 1", 40);
        course.addAssignment("Lab 2", 30);
        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("50 + 60 -> false")
    void testIsAssignmentWeightValid3() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        course.addAssignment("Lab 1", 50);
        course.addAssignment("Lab 2", 60);
        boolean expected = false;
        boolean actual = course.isAssignmentWeightValid();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("first time register -> true")
    void testRegisterStudent1() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        Student student = new Student("Alice", Student.Gender.FEMALE, null, department);
        boolean expected = true;
        boolean actual = course.registerStudent(student);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("register again -> false")
    void testRegisterStudent2() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        Student student = new Student("Alice", Student.Gender.FEMALE, null, department);
        course.registerStudent(student);
        boolean expected = false;
        boolean actual = course.registerStudent(student);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void testRegisterStudent3() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        Student student = null;
        boolean expected = false;
        boolean actual = course.registerStudent(student);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("80 -> 80")
    void testCalcStudentsAverage1() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        Student student = new Student("Alice", Student.Gender.FEMALE, null, department);
        course.registerStudent(student);
        course.addAssignment("Final Exam", 100);
        course.getAssignments().get(0).setScores(Arrays.asList(80));

        int[] expected = {80};
        int[] actual = course.calcStudentsAverage();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("40 + 60 -> 82")
    void testCalcStudentsAverage2() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        Student student = new Student("Alice", Student.Gender.FEMALE, null, department);
        course.registerStudent(student);
        course.addAssignment("Lab1", 40);
        course.addAssignment("Lab2", 60);
        course.getAssignments().get(0).setScores(Arrays.asList(70));
        course.getAssignments().get(1).setScores(Arrays.asList(90));

        int[] expected = {82};
        int[] actual = course.calcStudentsAverage();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("no student -> true")
    void testAddAssignment1() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        boolean expected = true;
        boolean actual = course.addAssignment("Lab 1", 40);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1, course.getAssignments().size());
        Assertions.assertEquals(0, course.getAssignments().get(0).getScores().size());
    }

    @Test
    @DisplayName("one student -> true")
    void testAddAssignment2() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        Student student = new Student("Alice", Student.Gender.FEMALE, null, department);
        course.registerStudent(student);
        boolean expected = true;
        boolean actual = course.addAssignment("Lab 1", 40);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1, course.getAssignments().size());
        Assertions.assertEquals(1, course.getAssignments().get(0).getScores().size());
    }

    @Test
    @DisplayName("two student -> true")
    void testAddAssignment3() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming", 3.0, department);
        Student student1 = new Student("Alice", Student.Gender.FEMALE, null, department);
        Student student2 = new Student("Bob", Student.Gender.MALE, null, department);
        course.registerStudent(student1);
        course.registerStudent(student2);

        boolean expected = true;
        boolean actual = course.addAssignment("Lab 1", 40);
        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(1, course.getAssignments().size());
        Assertions.assertEquals(2, course.getAssignments().get(0).getScores().size());
    }
}
