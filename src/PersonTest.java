import org.junit.Test; // JDK 5.0 annotation support
import static org.junit.Assert.assertTrue; // Using JDK 5.0 static imports
import static org.junit.Assert.assertFalse; // Using JDK 5.0 static imports
public class PersonTest {
    /**
     * A test to verify equals method.
     */
    @Test
    public void checkEquals() {

        Person p1 = new Person("Kent", "Yang", "kentyang@san.rr.com", "8588296201");
        assertTrue(p1.equals(p1)); // first check in equals method
        assertFalse(p1.equals(null)); //second check in equals method
        assertFalse(p1.equals(new Object())); // third check in equals method
        Person p2 = new Person("Kent", "Yang", "kentyang@san.rr.com", "8588296201");
        assertTrue(p1.equals(p2)); // Check for deep comparison
        p1 = new Person("Kent", "Yang", "kentyang@san.rr.com", "8588296201");
        p2 = new Person("David", "Yang", "davidyang@yahoo.com", "8588296201");
        assertFalse(p1.equals(p2)); // Check for deep comparison
    }
}