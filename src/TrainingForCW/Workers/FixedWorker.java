package TrainingForCW.Workers;

public class FixedWorker extends Worker {
    private final double fixed_salary;

    public FixedWorker(String surname, String name, double fixed_salary) {
        super(surname, name);
        this.fixed_salary = fixed_salary;
        middleSalary();
    }

    @Override
    public void middleSalary() { middle_salary = fixed_salary; }
}
