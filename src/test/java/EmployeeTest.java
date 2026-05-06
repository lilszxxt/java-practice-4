import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for Employee class.
 */
public class EmployeeTest {

    /**
     * Checks exception in setter.
     */
    @Test
    public void shouldThrowExceptionWhenInvalidSalaryInSetter() {
        Employee employee = new Employee("Oleh", "Manager", 30, 30000, "Sales");

        assertThrows(IllegalArgumentException.class, () -> {
            employee.setSalary(-1000);
        });
    }

    /**
     * Checks exception in constructor.
     */
    @Test
    public void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("", "Manager", 15, -500, "");
        });
    }
}