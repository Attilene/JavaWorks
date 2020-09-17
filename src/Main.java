import Seminar_2.*;
import Seminar_1.*;
//import Seminar_2.Task3_Hierarchy.*;
//import Seminar_2.Task3_Hierarchy.Shape;
import Seminar_2.Task4_Abstract_Hierarchy.*;
import Seminar_2.Task4_Abstract_Hierarchy.Shape;
import Seminar_2.Task6_Seabattle.*;
import Seminar_3.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
//        ЗАДАНИЕ 6 МОРСКОЙ БОЙ

//        User_Interface ship = new User_Interface();
//        ship.newGame();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(10);
        arr.add(1);
        arr.add(2);
        Collections coll = new Collections();
        System.out.println(coll.remDupl(arr));
    }
}
