import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests for Employee class.
 */
public class EmployeeTest {

    /**
     * Checks exception when invalid salary is set.
     */
    @Test
    public void shouldThrowExceptionWhenInvalidSalaryInSetter() {
        Address address = new Address("Kyiv", "Shevchenko");

        Employee employee = new Employee(
                "Oleh",
                "Manager",
                30,
                30000,
                Department.IT,
                address
        );

        assertThrows(IllegalArgumentException.class, () -> {
            employee.setSalary(-1000);
        });
    }

    /**
     * Checks exception when constructor receives invalid data.
     */
    @Test
    public void shouldThrowExceptionWhenInvalidConstructorData() {
        Address address = new Address("Kyiv", "Shevchenko");

        assertThrows(IllegalArgumentException.class, () -> {
            new Employee(
                    "",
                    "Manager",
                    15,
                    -500,
                    Department.IT,
                    address
            );
        });
    }

    /**
     * Checks exception when invalid address is used.
     */
    @Test
    public void shouldThrowExceptionWhenAddressIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee(
                    "Oleh",
                    "Manager",
                    30,
                    30000,
                    Department.IT,
                    null
            );
        });
    }
}