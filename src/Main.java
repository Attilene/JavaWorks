import Seminar_2.*;
import Seminar_1.*;

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

//        ЗАДАНИЕ 5 ВЕС ЧИСЕЛ

        int[] count = {2, 4, 3, 0, 10};
        int[] weight = {1, 3, 12, 9, 5};
        Task5_Weight mass = new Task5_Weight(count, weight);
        System.out.println(mass.RandomWeight());
    }
}
