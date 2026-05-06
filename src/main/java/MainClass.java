import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class with console menu.
 */
public class MainClass {

    /**
     * Program entry point.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<Employee>();

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
     * Prints console menu.
     */
    public static void printMenu() {
        System.out.println();
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести інформацію про всі об'єкти");
        System.out.println("3. Завершити роботу");
    }

    /**
     * Creates employee and adds it to list.
     *
     * @param scanner scanner object
     * @param employees list of employees
     */
    public static void createEmployee(Scanner scanner, ArrayList<Employee> employees) {
        try {
            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");
            String department = readString(scanner, "Відділ: ");

            Employee employee = new Employee(name, position, age, salary, department);
            employees.add(employee);

            System.out.println("Працівника успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }

    /**
     * Prints all employees.
     *
     * @param employees list of employees
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
     * Reads non-empty string.
     *
     * @param scanner scanner object
     * @param message input message
     * @return string value
     */
    public static String readString(Scanner scanner, String message) {
        System.out.print(message);
        String value = scanner.nextLine();

        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Рядок не може бути порожнім.");
        }

        return value;
    }

    /**
     * Reads integer value.
     *
     * @param scanner scanner object
     * @param message input message
     * @return integer value
     */
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

    /**
     * Reads double value.
     *
     * @param scanner scanner object
     * @param message input message
     * @return double value
     */
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