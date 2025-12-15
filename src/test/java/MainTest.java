import org.cynthia.Address;
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
}
