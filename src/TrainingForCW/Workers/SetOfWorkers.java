package TrainingForCW.Workers;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

public class SetOfWorkers {
    private ArrayList<Worker> workers;

    public SetOfWorkers() { workers = new ArrayList<>(); }

    public void addWorker(Worker worker) { workers.add(worker); }

    public void removeWorker(Worker worker) { workers.remove(worker); }

    public void outToFile(){
        String[] nameClass;
        try {
            FileWriter writer = new FileWriter("D://Финашка/Java/JavaWorks/JavaWork2/src/TrainingForCW/Workers/SetOfWorkers.txt", false);
            for (Worker worker: getWorkers()) {
                nameClass = worker.getClass().getName().split("\\.");
                writer.write(worker.getID() + " " + worker.getSurname() + " " + worker.getName() + " " + worker.middle_salary + " " + nameClass[nameClass.length - 1]);
                writer.write("\n");
                writer.flush();
            }
        }
        catch (IOException e) { System.out.println("File creation aborted"); }
    }

    public void inFromFile(){
        Worker worker;
        workers = new ArrayList<>();
        String line;
        String[] data;
        try {
            File file = new File("D://Финашка/Java/JavaWorks/JavaWork2/src/TrainingForCW/Workers/SetOfWorkers.txt");
            FileReader reader = new FileReader(file);
            BufferedReader readline = new BufferedReader(reader);
            line = readline.readLine();
            while (line != null) {
                worker = null;
                data = line.split(" ");
                if (data.length != 5) throw new DataFormatException();
                if (data[data.length - 1].equals("HourlyWorker"))
                    worker = new HourlyWorker(data[1], data[2], Double.parseDouble(data[3]) / 20.8 / 8);
                else if (data[data.length - 1].equals("FixedWorker"))
                    worker = new FixedWorker(data[1], data[2], Double.parseDouble(data[3]));
                if (worker != null) workers.add(worker);
                line = readline.readLine();
            }
        }
        catch (DataFormatException e) { System.out.println("Data is incorrect"); }
        catch (FileNotFoundException e) { System.out.println("File not found");}
        catch (IOException e) { System.out.println("File creation aborted"); }
    }

    public ArrayList<Worker> getWorkers() {
        ArrayList<Worker> res = workers;
        res.sort((o1, o2) -> o1.getSurname().compareTo(o2.getSurname()));
        res.sort((o1, o2) -> Double.compare(o2.middle_salary, o1.middle_salary));
        return res;
    }

    public ArrayList<String> getFirstNames(int amount) {
        int count = 0;
        ArrayList<String> res = new ArrayList<>();
        while (count != amount) {
            try {
                res.add(workers.get(count).getSurname() + " " + workers.get(count).getName());
                count++;
            }
            catch (IndexOutOfBoundsException e) { break; }
        }
        return res;
    }

    public ArrayList<String> getLastID(int amount) {
        int count = workers.size() - 1;
        ArrayList<String> res = new ArrayList<>();
        while (count != workers.size() - (amount + 1)) {
            try {
                res.add(workers.get(count).getID());
                count--;
            }
            catch (IndexOutOfBoundsException e) { break; }
        }
        return res;
    }

    public static void main(String[] args) {
//        Worker worker1 = new HourlyWorker("Derbin", "Dmitriy", 400);
//        Worker worker2 = new HourlyWorker("Bakanov", "Artem", 600);
//        Worker worker3 = new FixedWorker("Zheleznyakov", "Mikhail", 60000);
//        Worker worker4 = new FixedWorker("Khalilov", "Artem", 55000);
//        Worker worker5 = new FixedWorker("Tkachev", "Sergei", 80000);
//        Worker worker6 = new FixedWorker("Bibik", "Aleksandr", 80000);
        SetOfWorkers setOfWorkers = new SetOfWorkers();
        setOfWorkers.inFromFile();
//        setOfWorkers.addWorker(worker1);
//        setOfWorkers.addWorker(worker2);
//        setOfWorkers.addWorker(worker3);
//        setOfWorkers.addWorker(worker4);
//        setOfWorkers.addWorker(worker5);
//        setOfWorkers.addWorker(worker6);
        setOfWorkers.outToFile();

        for (Worker worker: setOfWorkers.getWorkers()) {
            System.out.println(worker.getID() + " " + worker.getSurname() + " " + worker.getName() + " " + worker.middle_salary);
        }
        System.out.println();
        for (String str: setOfWorkers.getFirstNames(5)) {
            System.out.println(str);
        }
        System.out.println();
        for (String str: setOfWorkers.getLastID(3)) {
            System.out.println(str);
        }
    }
}
