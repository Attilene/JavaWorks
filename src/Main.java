//import Seminar_2.Task3_Hierarchy.*;
//import Seminar_2.Task3_Hierarchy.Shape;
import Seminar_2.Task6_Seabattle.*;
import Seminar_2.Task6_Seabattle.Map;
import Seminar_3.*;
import Seminar_4.*;
import Seminar_6.*;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Семинар 2 ЗАДАНИЕ 6 МОРСКОЙ БОЙ

//        User_Interface ship = new User_Interface();
//        ship.newGame();

//        Client client = new Client();
//        client.addClient();

//        Семинар 4 Итераторы
//        Integer[][] arr1 = {{1, 2, 3, 5}, {4, 5, 6, 1}, {7, 8, 9, 10}};
//        Integer[] arr2 = {11, 12, 13, 14, 15, 16, 17, 18, 19};
//        Matrix_Iterat<Integer> iter1 = new Matrix_Iterat<>(arr1);
//        Iterat<Integer> iter2 = new Iterat<>(arr2);
//        IterAndStr<Integer> iter3 = new IterAndStr<>(iter2);
//        FlatIterator<String> iter4 = new FlatIterator<>(iter3);
////        Double_Iterator<Integer> diter = new Double_Iterator<>(iter1, iter2);
////        Matrix_Iterat<Integer> iterat = new Matrix_Iterat<>(arr);
//        while (iter4.hasNext()) {
//            System.out.println(iter4.next());
//        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello");
        StrBuilder strBuilder = new StrBuilder(stringBuilder);
        strBuilder.append("y");
        strBuilder.replace(0, 2, "qw");
        strBuilder.reverse();
        strBuilder.print();
        strBuilder.undo();
        strBuilder.print();
        strBuilder.undo();
        strBuilder.print();
        strBuilder.undo();
        strBuilder.print();
    }
}
