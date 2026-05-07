public class Manager extends FullTimeEmployee {

    private int teamSize;
    private double managementBonus;

    public Manager(String name, String position, int age, double salary,
                   int vacationDays, double bonus,
                   int teamSize, double managementBonus) {
        super(name, position, age, salary, vacationDays, bonus);
        setTeamSize(teamSize);
        setManagementBonus(managementBonus);
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        if (teamSize <= 0) {
            throw new IllegalArgumentException("Team size must be greater than 0.");
        }
        this.teamSize = teamSize;
    }

    public double getManagementBonus() {
        return managementBonus;
    }

    public void setManagementBonus(double managementBonus) {
        if (managementBonus < 0) {
            throw new IllegalArgumentException("Management bonus cannot be negative.");
        }
        this.managementBonus = managementBonus;
    }

    @Override
    public String toString() {
        return "Manager{"
                + "name='" + getName() + '\''
                + ", position='" + getPosition() + '\''
                + ", age=" + getAge()
                + ", salary=" + getSalary()
                + ", vacationDays=" + getVacationDays()
                + ", bonus=" + getBonus()
                + ", teamSize=" + teamSize
                + ", managementBonus=" + managementBonus
                + '}';
    }
}