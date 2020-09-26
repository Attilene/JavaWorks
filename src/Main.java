//import Seminar_2.Task3_Hierarchy.*;
//import Seminar_2.Task3_Hierarchy.Shape;
import Seminar_2.Task6_Seabattle.*;
import Seminar_3.*;
import Seminar_4.*;

import java.io.IOException;
import java.util.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
//        Семинар 2 ЗАДАНИЕ 6 МОРСКОЙ БОЙ

//        User_Interface ship = new User_Interface();
//        ship.newGame();


//        Семинар 4 Ключ поменять на значение

//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put("hello", 2);
//        map.put("bye", 2);
//        map.put("qwerty", 3);
//        Dictionaries diction = new Dictionaries();
//        Map<Integer, HashSet<String>> map2 = new HashMap<Integer, HashSet<String>>();
//        map2 = diction.changeKeyValue(map);
//        for (Map.Entry<Integer, HashSet<String>> entry: map2.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }

//        Семинар 4 Итераторы
        Integer[][] arr1 = {{1, 2, 3, 5}, {4, 5, 6, 1}, {7, 8, 9, 10}};
        Integer[] arr2 = {11, 12, 13, 14, 15, 16, 17, 18, 19};
        Matrix_Iterat<Integer> iter1 = new Matrix_Iterat<>(arr1);
        Iterat<Integer> iter2 = new Iterat<>(arr2);
        IterAndStr<Integer> iter3 = new IterAndStr<>(iter1);
//        Double_Iterator<Integer> diter = new Double_Iterator<>(iter1, iter2);
//        Matrix_Iterat<Integer> iterat = new Matrix_Iterat<>(arr);
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }
    }
}
