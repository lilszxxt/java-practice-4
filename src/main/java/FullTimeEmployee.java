/**
 * Class that describes a full-time employee.
 */
public class FullTimeEmployee extends Employee {

    private int vacationDays;
    private double bonus;

    public FullTimeEmployee(
            String name,
            String position,
            int age,
            double salary,
            int vacationDays,
            double bonus
    ) {

        super(name, position, age, salary);

        setVacationDays(vacationDays);
        setBonus(bonus);
    }

    public int getVacationDays() {

        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {

        if (vacationDays < 0) {

            throw new IllegalArgumentException(
                    "Vacation days cannot be negative."
            );
        }

        this.vacationDays = vacationDays;
    }

    public double getBonus() {

        return bonus;
    }

    public void setBonus(double bonus) {

        if (bonus < 0) {

            throw new IllegalArgumentException(
                    "Bonus cannot be negative."
            );
        }

        this.bonus = bonus;
    }

    @Override
    public String toString() {

        return "FullTimeEmployee{"
                + "name='" + getName() + '\''
                + ", position='" + getPosition() + '\''
                + ", age=" + getAge()
                + ", salary=" + getSalary()
                + ", vacationDays=" + vacationDays
                + ", bonus=" + bonus
                + '}';
    }
}