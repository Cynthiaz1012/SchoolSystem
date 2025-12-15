import org.cynthia.Address;
import org.cynthia.Course;
import org.cynthia.Department;
import org.cynthia.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("normal -> true")
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
}
