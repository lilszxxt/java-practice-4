import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

    private static final String FILE_NAME = "input.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = loadEmployeesFromFile(FILE_NAME);

        boolean running = true;

        while (running) {
            printMainMenu();

            int choice = readInt(scanner, "Оберіть пункт меню: ");

            switch (choice) {
                case 1:
                    createObjectMenu(scanner, employees);
                    break;
                case 2:
                    printEmployees(employees);
                    break;
                case 3:
                    saveEmployeesToFile(employees, FILE_NAME);
                    running = false;
                    System.out.println("Дані збережено. Роботу завершено.");
                    break;
                default:
                    System.out.println("Помилка: такого пункту меню немає.");
            }
        }

        scanner.close();
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println("1. Створити новий об'єкт");
        System.out.println("2. Вивести інформацію про всі об'єкти");
        System.out.println("3. Завершити роботу програми");
    }

    public static void createObjectMenu(Scanner scanner, ArrayList<Employee> employees) {
        boolean creating = true;

        while (creating) {
            printCreateMenu();

            int choice = readInt(scanner, "Оберіть тип об'єкта: ");

            switch (choice) {
                case 1:
                    createEmployee(scanner, employees);
                    creating = false;
                    break;
                case 2:
                    createContractEmployee(scanner, employees);
                    creating = false;
                    break;
                case 3:
                    createFullTimeEmployee(scanner, employees);
                    creating = false;
                    break;
                case 4:
                    createManager(scanner, employees);
                    creating = false;
                    break;
                case 5:
                    createInternEmployee(scanner, employees);
                    creating = false;
                    break;
                case 6:
                    creating = false;
                    break;
                default:
                    System.out.println("Помилка: такого типу немає.");
            }
        }
    }

    public static void printCreateMenu() {
        System.out.println();
        System.out.println("1. Employee");
        System.out.println("2. ContractEmployee");
        System.out.println("3. FullTimeEmployee");
        System.out.println("4. Manager");
        System.out.println("5. InternEmployee");
        System.out.println("6. Повернутися до головного меню");
    }

    public static void createEmployee(Scanner scanner, ArrayList<Employee> employees) {
        try {
            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");

            Employee employee = new Employee(name, position, age, salary);
            employees.add(employee);

            System.out.println("Employee успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }

    public static void createContractEmployee(Scanner scanner, ArrayList<Employee> employees) {
        try {
            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");
            int contractMonths = readInt(scanner, "Тривалість контракту в місяцях: ");
            double hourlyRate = readDouble(scanner, "Погодинна ставка: ");

            Employee employee = new ContractEmployee(
                    name,
                    position,
                    age,
                    salary,
                    contractMonths,
                    hourlyRate
            );

            employees.add(employee);

            System.out.println("ContractEmployee успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }

    public static void createFullTimeEmployee(Scanner scanner, ArrayList<Employee> employees) {
        try {
            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");
            int vacationDays = readInt(scanner, "Кількість днів відпустки: ");
            double bonus = readDouble(scanner, "Бонус: ");

            Employee employee = new FullTimeEmployee(
                    name,
                    position,
                    age,
                    salary,
                    vacationDays,
                    bonus
            );

            employees.add(employee);

            System.out.println("FullTimeEmployee успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }

    public static void createManager(Scanner scanner, ArrayList<Employee> employees) {
        try {
            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");
            int vacationDays = readInt(scanner, "Кількість днів відпустки: ");
            double bonus = readDouble(scanner, "Бонус: ");
            int teamSize = readInt(scanner, "Розмір команди: ");
            double managementBonus = readDouble(scanner, "Бонус керівника: ");

            Employee employee = new Manager(
                    name,
                    position,
                    age,
                    salary,
                    vacationDays,
                    bonus,
                    teamSize,
                    managementBonus
            );

            employees.add(employee);

            System.out.println("Manager успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }

    public static void createInternEmployee(Scanner scanner, ArrayList<Employee> employees) {
        try {
            String name = readString(scanner, "Ім'я: ");
            String position = readString(scanner, "Посада: ");
            int age = readInt(scanner, "Вік: ");
            double salary = readDouble(scanner, "Зарплата: ");
            String university = readString(scanner, "Університет: ");
            int internshipMonths = readInt(scanner, "Тривалість стажування в місяцях: ");

            Employee employee = new InternEmployee(
                    name,
                    position,
                    age,
                    salary,
                    university,
                    internshipMonths
            );

            employees.add(employee);

            System.out.println("InternEmployee успішно додано.");
        } catch (IllegalArgumentException e) {
            System.out.println("Помилка введення: " + e.getMessage());
        }
    }

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

    public static ArrayList<Employee> loadEmployeesFromFile(String fileName) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("Файл " + fileName + " не знайдено. Створено порожній список.");
            return employees;
        }

        try {
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (!line.trim().isEmpty()) {
                    Employee employee = parseEmployee(line);

                    if (employee != null) {
                        employees.add(employee);
                    }
                }
            }

            fileScanner.close();

            System.out.println("Дані з файлу завантажено.");
        } catch (FileNotFoundException e) {
            System.out.println("Помилка читання файлу: " + e.getMessage());
        }

        return employees;
    }

    public static Employee parseEmployee(String line) {
        try {
            String[] parts = line.split(";");

            String type = parts[0];

            if ("EMPLOYEE".equals(type)) {
                return new Employee(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4])
                );
            }

            if ("CONTRACT".equals(type)) {
                return new ContractEmployee(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4]),
                        Integer.parseInt(parts[5]),
                        Double.parseDouble(parts[6])
                );
            }

            if ("FULLTIME".equals(type)) {
                return new FullTimeEmployee(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4]),
                        Integer.parseInt(parts[5]),
                        Double.parseDouble(parts[6])
                );
            }

            if ("MANAGER".equals(type)) {
                return new Manager(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4]),
                        Integer.parseInt(parts[5]),
                        Double.parseDouble(parts[6]),
                        Integer.parseInt(parts[7]),
                        Double.parseDouble(parts[8])
                );
            }

            if ("INTERN".equals(type)) {
                return new InternEmployee(
                        parts[1],
                        parts[2],
                        Integer.parseInt(parts[3]),
                        Double.parseDouble(parts[4]),
                        parts[5],
                        Integer.parseInt(parts[6])
                );
            }

            System.out.println("Невідомий тип об'єкта у файлі: " + type);
        } catch (Exception e) {
            System.out.println("Некоректний рядок у файлі: " + line);
        }

        return null;
    }

    public static void saveEmployeesToFile(ArrayList<Employee> employees, String fileName) {
        try {
            PrintWriter writer = new PrintWriter(fileName);

            for (Employee employee : employees) {
                writer.println(formatEmployee(employee));
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Помилка запису у файл: " + e.getMessage());
        }
    }

    public static String formatEmployee(Employee employee) {
        if (employee instanceof Manager) {
            Manager manager = (Manager) employee;

            return "MANAGER;"
                    + manager.getName() + ";"
                    + manager.getPosition() + ";"
                    + manager.getAge() + ";"
                    + manager.getSalary() + ";"
                    + manager.getVacationDays() + ";"
                    + manager.getBonus() + ";"
                    + manager.getTeamSize() + ";"
                    + manager.getManagementBonus();
        }

        if (employee instanceof InternEmployee) {
            InternEmployee internEmployee = (InternEmployee) employee;

            return "INTERN;"
                    + internEmployee.getName() + ";"
                    + internEmployee.getPosition() + ";"
                    + internEmployee.getAge() + ";"
                    + internEmployee.getSalary() + ";"
                    + internEmployee.getUniversity() + ";"
                    + internEmployee.getInternshipMonths();
        }

        if (employee instanceof ContractEmployee) {
            ContractEmployee contractEmployee = (ContractEmployee) employee;

            return "CONTRACT;"
                    + contractEmployee.getName() + ";"
                    + contractEmployee.getPosition() + ";"
                    + contractEmployee.getAge() + ";"
                    + contractEmployee.getSalary() + ";"
                    + contractEmployee.getContractMonths() + ";"
                    + contractEmployee.getHourlyRate();
        }

        if (employee instanceof FullTimeEmployee) {
            FullTimeEmployee fullTimeEmployee = (FullTimeEmployee) employee;

            return "FULLTIME;"
                    + fullTimeEmployee.getName() + ";"
                    + fullTimeEmployee.getPosition() + ";"
                    + fullTimeEmployee.getAge() + ";"
                    + fullTimeEmployee.getSalary() + ";"
                    + fullTimeEmployee.getVacationDays() + ";"
                    + fullTimeEmployee.getBonus();
        }

        return "EMPLOYEE;"
                + employee.getName() + ";"
                + employee.getPosition() + ";"
                + employee.getAge() + ";"
                + employee.getSalary();
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