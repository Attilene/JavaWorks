package ControlWork1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Garage {
    private Map<Car, Integer> map = new HashMap<>();
    private int maxCapacity;

    public Garage(Map<Car, Integer> map, int maxCapacity){
        this.maxCapacity = maxCapacity;
        if (map.keySet().size() <= this.maxCapacity) {
            this.map = map;
        }
    }

    public void autoOut() {
        for (Map.Entry<Car, Integer> ent: map.entrySet()) {
            System.out.println(ent.getKey().toString() + " " + ent.getValue());
        }
    }

    public void SortautoOut1() {
        ArrayList<Map.Entry<Car, Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue()));
        for (Map.Entry<Car, Integer> ent: arr) {
            System.out.println(ent.getKey().toString() + " " + ent.getValue());
        }
    }

    public void SortautoOut2() {
        ArrayList<Map.Entry<Car, Integer>> arr = new ArrayList<>(map.entrySet());
        arr.sort((o1, o2) -> Integer.compare(o1.getKey().price, o2.getKey().price));
        for (Map.Entry<Car, Integer> ent: arr) {
            System.out.println(ent.getKey().toString() + " " + ent.getValue());
        }
    }
}
