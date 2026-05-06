import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class with console menu.
 */
public class MainClass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();

        printHeader();

        boolean running = true;

        while (running) {
            printMenu();

            int choice = readInt(scanner, "Оберіть пункт меню: ");

            switch (choice) {
                case 1:
                    createEmployee(scanner, employees);
                    break;
                case 2:
                    printEmployees(employees);
                    break;
                case 3:
                    copyLastEmployee(employees);
                    break;
                case 4:
                    System.out.println("Кількість створених працівників: "
                            + Employee.getEmployeeCount());
                    break;
                case 5:
                    running = false;
                    System.out.println("Роботу завершено.");
                    break;
                default:
                    System.out.println("Помилка: такого пункту меню немає.");
            }
        }

        scanner.close();
    }

    /**
     * Prints information header.
     */
    public static void printHeader() {
        System.out.println("Практична робота №6");
        System.out.println("Класи, статичні члени, агрегація, enum");
    }

    /**
     * Prints menu.
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести інформацію про всі об'єкти");
        System.out.println("3. Скопіювати останній об'єкт");
        System.out.println("4. Показати кількість створених об'єктів");
        System.out.println("5. Завершити роботу");
    }

    /**
     * Creates employee.
     *
     * @param scanner scanner object
     * @param employees employee list
     */
    public static void createEmployee(Scanner scanner, ArrayList<Employee> employees) {
        try {
            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");
            Department department = readDepartment(scanner);
            String city = readString(scanner, "Місто: ");
            String street = readString(scanner, "Вулиця: ");

            Address address = new Address(city, street);
            Employee employee = new Employee(name, position, age, salary, department, address);

            employees.add(employee);

            System.out.println("Працівника успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }

    /**
     * Copies last employee in list.
     *
     * @param employees employee list
     */
    public static void copyLastEmployee(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Немає об'єкта для копіювання.");
            return;
        }

        Employee copy = new Employee(employees.get(employees.size() - 1));
        employees.add(copy);

        System.out.println("Останній об'єкт скопійовано.");
    }

    /**
     * Prints employees.
     *
     * @param employees employee list
     */
    public static void printEmployees(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("Список працівників порожній.");
            return;
        }

        System.out.println("Список працівників:");

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /**
     * Reads department enum.
     *
     * @param scanner scanner object
     * @return selected department
     */
    public static Department readDepartment(Scanner scanner) {
        while (true) {
            System.out.println("Оберіть відділ:");
            System.out.println("1. SALES");
            System.out.println("2. IT");
            System.out.println("3. HR");
            System.out.println("4. FINANCE");
            System.out.println("5. MANAGEMENT");

            int choice = readInt(scanner, "Ваш вибір: ");

            switch (choice) {
                case 1:
                    return Department.SALES;
                case 2:
                    return Department.IT;
                case 3:
                    return Department.HR;
                case 4:
                    return Department.FINANCE;
                case 5:
                    return Department.MANAGEMENT;
                default:
                    System.out.println("Помилка: такого відділу немає.");
            }
        }
    }

    public static String readString(Scanner scanner, String message) {
        System.out.print(message);
        String value = scanner.nextLine();

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути порожнім.");
        }

        return value;
    }

    public static int readInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Помилка: потрібно ввести ціле число.");
                scanner.nextLine();
            }
        }
    }

    public static double readDouble(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Помилка: потрібно ввести число.");
                scanner.nextLine();
            }
        }
    }
}