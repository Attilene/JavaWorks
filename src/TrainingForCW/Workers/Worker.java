package TrainingForCW.Workers;


import java.util.Random;

public abstract class Worker {
    private final Random rd;
    private final StringBuilder surname, name;
    private final Integer id;
    public double middle_salary;

    public Worker(String surname, String name) {
        rd = new Random();
        this.surname = new StringBuilder();
        this.name = new StringBuilder();
        this.surname.append(surname);
        this.name.append(name);
        this.id = rd.nextInt(1000);
    }

    public abstract void middleSalary();

    public String getID() { return id.toString(); }

    public String getSurname() { return surname.substring(0); }

    public String getName() { return name.substring(0); }
}