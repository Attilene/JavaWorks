package TrainingForCW.Workers;

public class HourlyWorker extends Worker {
    private final double rate;

    public HourlyWorker(String surname, String name, double rate) {
        super(surname, name);
        this.rate = rate;
        middleSalary();
    }

    @Override
    public void middleSalary() { middle_salary = 20.8 * 8 * rate; }
}
