import java.util.Objects;

/**
 * Class that describes an employee.
 */
public class Employee {

    private String name;
    private String position;
    private int age;
    private double salary;
    private String department;

    /**
     * Creates employee object.
     *
     * @param name employee name
     * @param position employee position
     * @param age employee age
     * @param salary employee salary
     * @param department employee department
     */
    public Employee(String name, String position, int age, double salary, String department) {
        setName(name);
        setPosition(position);
        setAge(age);
        setSalary(salary);
        setDepartment(department);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty.");
        }
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 70) {
            throw new IllegalArgumentException("Age must be from 18 to 70.");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be greater than 0.");
        }
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", position='" + position + '\''
                + ", age=" + age
                + ", salary=" + salary
                + ", department='" + department + '\''
                + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) obj;

        return age == employee.age
                && Double.compare(employee.salary, salary) == 0
                && Objects.equals(name, employee.name)
                && Objects.equals(position, employee.position)
                && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, age, salary, department);
    }
}