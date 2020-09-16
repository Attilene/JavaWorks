import Seminar_2.*;
import Seminar_1.*;
//import Seminar_2.Task3_Hierarchy.*;
//import Seminar_2.Task3_Hierarchy.Shape;
import Seminar_2.Task4_Abstract_Hierarchy.*;
import Seminar_2.Task4_Abstract_Hierarchy.Shape;
import Seminar_2.Task6_Seabattle.*;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        ЗАДАНИЕ 1 МАТРИЦЫ

//        double[][] matrix1 = {
//                {1, 2, -1},
//                {3, 1, 2},
//                {0, 2, 4}
//        };
//        Task1_Matrix matrix = new Task1_Matrix(matrix1);
//        double[][] matrix2 = {
//                {3, 6, 10},
//                {-2, 4, 5},
//                {12, -4, 2}
//        };
//        Task1_Matrix.matrout(matrix.plus(matrix2));
//        Task1_Matrix.matrout(matrix.minus(matrix2));
//        Task1_Matrix.matrout(matrix.mulcount(5));
//        Task1_Matrix.matrout(matrix.mulmat(matrix2));
//        Task1_Matrix.matrout(matrix.transpon());
//        Task1_Matrix.matrout(matrix.stepen(3));

//        ЗАДАНИЕ 2 ВЕКТОР

//        double[] t1 = {3, -3.5, 9};
//        double[] t2 = {-1, 7, 0};
//        Task2_Vector vect1 = new Task2_Vector(t1);
//        Task2_Vector vect2 = new Task2_Vector(t2);
//        Task2_Vector[] arrv = new Task2_Vector[5];
//        System.out.format("%.2f%n", vect1.length());
//        Task2_Vector.vectorOut(vect1.plus(vect2));
//        Task2_Vector.vectorOut(vect1.minus(vect2));
//        System.out.println();
//        arrv = Task2_Vector.arrvec(5);
//        for (int i = 0; i < 5; i++) {
//            Task2_Vector.vectorOut(arrv[i]);
//        }
//        System.out.println();
//        System.out.format("%.2f%n", vect1.angle(vect2));
//        System.out.format("%.2f%n", vect1.scalyar(vect2));
//        Task2_Vector.vectorOut(vect1.mult(vect2));

//        ЗАДАНИЕ 3 Иерархия классов

//        Shape pir = new Piramid(13, 3);
//        Shape cyl = new Cylinder(1, 8);
//        Shape paral = new Parallelepiped(15, 3);
//        Shape ball = new Ball(3);
//        Box box = new Box();
//        box.add(pir);
//        System.out.println(box.getVolume());
//        box.add(cyl);
//        System.out.println(box.getVolume());
//        box.add(paral);
//        System.out.println(box.getVolume());
//        box.add(ball);
//        System.out.println(box.getVolume());

//        ЗАДАНИЕ 4 Абстрактная иерархия классов

//        Shape pir = new Piramid(13, 3);
//        Shape cyl = new Cylinder(1, 8);
//        Shape paral = new Parallelepiped(15, 3);
//        Shape ball = new Ball(3);
//        Box box = new Box();
//        box.add(pir);
//        System.out.println(box.getVolume());
//        box.add(cyl);
//        System.out.println(box.getVolume());
//        box.add(paral);
//        System.out.println(box.getVolume());
//        box.add(ball);
//        System.out.println(box.getVolume());

//        ЗАДАНИЕ 5 ВЕС ЧИСЕЛ

//        int[] count = {2, 4, 3, 0, 10};
//        int[] weight = {1, 3, 12, 9, 5};
//        Task5_Weight mass = new Task5_Weight(count, weight);
//        System.out.println(mass.RandomWeight());

//        ЗАДАНИЕ 6 МОРСКОЙ БОЙ

        Map ship = new Map();
        ship.randomLoc();
        for (int i = 0; i < ship.map.length; i++) {
            for (int j = 0; j < ship.map.length; j++) {
                System.out.print(ship.map[i][j]);
            }
            System.out.println();
        }
    }
}
