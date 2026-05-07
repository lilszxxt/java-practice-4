import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeTest {

    @Test
    public void shouldThrowExceptionWhenInvalidSalaryInSetter() {
        Employee employee = new Employee("Oleh", "Manager", 30, 30000);

        assertThrows(IllegalArgumentException.class, () -> {
            employee.setSalary(-1000);
        });
    }

    @Test
    public void shouldThrowExceptionWhenInvalidConstructorData() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("", "Manager", 15, -500);
        });
    }

    @Test
    public void shouldThrowExceptionWhenInvalidContractMonths() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ContractEmployee("Oleh", "Developer", 30, 30000, 0, 500);
        });
    }

    @Test
    public void shouldThrowExceptionWhenInvalidBonus() {
        assertThrows(IllegalArgumentException.class, () -> {
            new FullTimeEmployee("Oleh", "Manager", 30, 30000, 20, -100);
        });
    }

    @Test
    public void shouldThrowExceptionWhenInvalidTeamSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Manager("Oleh", "Manager", 30, 30000, 20, 1000, 0, 500);
        });
    }

    @Test
    public void shouldThrowExceptionWhenInvalidUniversity() {
        assertThrows(IllegalArgumentException.class, () -> {
            new InternEmployee("Oleh", "Intern", 20, 10000, "", 6);
        });
    }
}