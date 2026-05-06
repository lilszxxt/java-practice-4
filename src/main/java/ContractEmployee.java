/**
 * Class that describes a contract employee.
 */
public class ContractEmployee extends Employee {

    private int contractMonths;
    private double hourlyRate;

    public ContractEmployee(
            String name,
            String position,
            int age,
            double salary,
            int contractMonths,
            double hourlyRate
    ) {

        super(name, position, age, salary);

        setContractMonths(contractMonths);
        setHourlyRate(hourlyRate);
    }

    public int getContractMonths() {

        return contractMonths;
    }

    public void setContractMonths(int contractMonths) {

        if (contractMonths <= 0) {

            throw new IllegalArgumentException(
                    "Contract months must be greater than 0."
            );
        }

        this.contractMonths = contractMonths;
    }

    public double getHourlyRate() {

        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {

        if (hourlyRate <= 0) {

            throw new IllegalArgumentException(
                    "Hourly rate must be greater than 0."
            );
        }

        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {

        return "ContractEmployee{"
                + "name='" + getName() + '\''
                + ", position='" + getPosition() + '\''
                + ", age=" + getAge()
                + ", salary=" + getSalary()
                + ", contractMonths=" + contractMonths
                + ", hourlyRate=" + hourlyRate
                + '}';
    }
}