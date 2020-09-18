package Seminar_3;

import java.util.*;

public class Collections {
    ArrayList<Integer> arr = new ArrayList<>();
    LinkedList<Integer> link = new LinkedList<>();
    Random rd = new Random();

    public <T> Collection<T> remDupl(Collection<T> collection) {
//        Коллекция без дубликатов
        return new HashSet<>(collection);
    }

    public void addMill() {
//        Метод добавления 1000000 рандомных символов в ArrayList и LinkedList
        for (int i = 0; i < 1000000; i++) {
            arr.add(rd.nextInt(2000000) - 1000000);
            link.add(rd.nextInt(2000000) - 1000000);
        }
    }

    public void retTime() {
//        Метод подсчета времени выполнения (в миллисекундах) алгоритма
//        выборки 100000 случайных чисел из ArrayList и LinkedList
        int c;
//        Спойлер: работа с ArrayList происходит гораздо быстрее, чем с LinkedList
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            c = arr.get(rd.nextInt(1000000));
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("The run time of the first algorithm: " + (finish1 - start1));
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            c = link.get(rd.nextInt(1000000));
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("The run time of the second algorithm: " + (finish2 - start2));
    }
}
