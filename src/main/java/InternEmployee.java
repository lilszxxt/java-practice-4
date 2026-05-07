public class InternEmployee extends Employee {

    private String university;
    private int internshipMonths;

    public InternEmployee(String name, String position, int age, double salary,
                          String university, int internshipMonths) {
        super(name, position, age, salary);
        setUniversity(university);
        setInternshipMonths(internshipMonths);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        if (university == null || university.trim().isEmpty()) {
            throw new IllegalArgumentException("University cannot be empty.");
        }
        this.university = university;
    }

    public int getInternshipMonths() {
        return internshipMonths;
    }

    public void setInternshipMonths(int internshipMonths) {
        if (internshipMonths <= 0) {
            throw new IllegalArgumentException("Internship months must be greater than 0.");
        }
        this.internshipMonths = internshipMonths;
    }

    @Override
    public String toString() {
        return "InternEmployee{"
                + "name='" + getName() + '\''
                + ", position='" + getPosition() + '\''
                + ", age=" + getAge()
                + ", salary=" + getSalary()
                + ", university='" + university + '\''
                + ", internshipMonths=" + internshipMonths
                + '}';
    }
}