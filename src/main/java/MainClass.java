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

        boolean running = true;

        while (running) {

            printMenu();

            int choice = readInt(scanner, "Оберіть пункт меню: ");

            switch (choice) {

                case 1:
                    createEmployee(scanner, employees);
                    break;

                case 2:
                    createContractEmployee(scanner, employees);
                    break;

                case 3:
                    createFullTimeEmployee(scanner, employees);
                    break;

                case 4:
                    printEmployees(employees);
                    break;

                case 5:
                    running = false;
                    System.out.println("Роботу завершено.");
                    break;

                default:
                    System.out.println(
                            "Помилка: такого пункту меню немає."
                    );
            }
        }

        scanner.close();
    }

    /**
     * Prints menu.
     */
    public static void printMenu() {

        System.out.println();
        System.out.println("1. Створити Employee");
        System.out.println("2. Створити ContractEmployee");
        System.out.println("3. Створити FullTimeEmployee");
        System.out.println("4. Вивести інформацію про всі об'єкти");
        System.out.println("5. Завершити роботу");
    }

    /**
     * Creates Employee object.
     */
    public static void createEmployee(
            Scanner scanner,
            ArrayList<Employee> employees
    ) {

        try {

            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");

            Employee employee = new Employee(
                    name,
                    position,
                    age,
                    salary
            );

            employees.add(employee);

            System.out.println("Employee успішно додано.");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Помилка введення: " + e.getMessage()
            );
        }
    }

    /**
     * Creates ContractEmployee object.
     */
    public static void createContractEmployee(
            Scanner scanner,
            ArrayList<Employee> employees
    ) {

        try {

            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");

            int contractMonths = readInt(
                    scanner,
                    "Тривалість контракту в місяцях: "
            );

            double hourlyRate = readDouble(
                    scanner,
                    "Погодинна ставка: "
            );

            Employee employee = new ContractEmployee(
                    name,
                    position,
                    age,
                    salary,
                    contractMonths,
                    hourlyRate
            );

            employees.add(employee);

            System.out.println(
                    "ContractEmployee успішно додано."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Помилка введення: " + e.getMessage()
            );
        }
    }

    /**
     * Creates FullTimeEmployee object.
     */
    public static void createFullTimeEmployee(
            Scanner scanner,
            ArrayList<Employee> employees
    ) {

        try {

            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");

            int vacationDays = readInt(
                    scanner,
                    "Кількість днів відпустки: "
            );

            double bonus = readDouble(
                    scanner,
                    "Бонус: "
            );

            Employee employee = new FullTimeEmployee(
                    name,
                    position,
                    age,
                    salary,
                    vacationDays,
                    bonus
            );

            employees.add(employee);

            System.out.println(
                    "FullTimeEmployee успішно додано."
            );

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Помилка введення: " + e.getMessage()
            );
        }
    }

    /**
     * Prints all employees.
     */
    public static void printEmployees(
            ArrayList<Employee> employees
    ) {

        if (employees.isEmpty()) {

            System.out.println(
                    "Список працівників порожній."
            );

            return;
        }

        System.out.println("Список працівників:");

        for (Employee employee : employees) {

            System.out.println(employee);
        }
    }

    /**
     * Reads string value.
     */
    public static String readString(
            Scanner scanner,
            String message
    ) {

        System.out.print(message);

        String value = scanner.nextLine();

        if (value.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Рядок не може бути порожнім."
            );
        }

        return value;
    }

    /**
     * Reads integer value.
     */
    public static int readInt(
            Scanner scanner,
            String message
    ) {

        while (true) {

            try {

                System.out.print(message);

                int value = scanner.nextInt();

                scanner.nextLine();

                return value;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Помилка: потрібно ввести ціле число."
                );

                scanner.nextLine();
            }
        }
    }

    /**
     * Reads double value.
     */
    public static double readDouble(
            Scanner scanner,
            String message
    ) {

        while (true) {

            try {

                System.out.print(message);

                double value = scanner.nextDouble();

                scanner.nextLine();

                return value;

            } catch (InputMismatchException e) {

                System.out.println(
                        "Помилка: потрібно ввести число."
                );

                scanner.nextLine();
            }
        }
    }
}