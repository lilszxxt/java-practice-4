import java.util.Objects;

/**
 * Class that describes an employee.
 */
public class Employee {

    private static int employeeCount = 0;

    private String name;
    private String position;
    private int age;
    private double salary;
    private Department department;
    private Address address;

    /**
     * Creates employee object.
     *
     * @param name employee name
     * @param position employee position
     * @param age employee age
     * @param salary employee salary
     * @param department employee department
     * @param address employee address
     */
    public Employee(String name, String position, int age,
                    double salary, Department department, Address address) {
        setName(name);
        setPosition(position);
        setAge(age);
        setSalary(salary);
        setDepartment(department);
        setAddress(address);

        employeeCount++;
    }

    /**
     * Copy constructor.
     *
     * @param employee source employee
     */
    public Employee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        setName(employee.name);
        setPosition(employee.position);
        setAge(employee.age);
        setSalary(employee.salary);
        setDepartment(employee.department);
        setAddress(new Address(employee.address));

        employeeCount++;
    }

    /**
     * Returns count of created employees.
     *
     * @return employee count
     */
    public static int getEmployeeCount() {
        return employeeCount;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }

        this.department = department;
    }

    public Address getAddress() {
        return new Address(address);
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }

        this.address = new Address(address);
    }

    @Override
    public String toString() {
        return "Employee{"
                + "name='" + name + '\''
                + ", position='" + position + '\''
                + ", age=" + age
                + ", salary=" + salary
                + ", department=" + department
                + ", address=" + address
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
                && department == employee.department
                && Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, age, salary, department, address);
    }
}