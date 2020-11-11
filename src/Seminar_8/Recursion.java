package Seminar_8;

import java.beans.Expression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Recursion {
    interface Equation{
        double f(double x);
    }

    public static void allNumber(int n) {
        if (n != 1) allNumber(n - 1);
        System.out.println(n);
    }

    public static <T> boolean elemInArr1(ArrayList<T> arr, T elem, int index) {
        if (index == arr.size()) return false;
        else if (elem == arr.get(index)) return true;
        return elemInArr1(arr, elem, index + 1);
    }

    public static <T> boolean elemInArr1(ArrayList<T> arr, T elem) { return elemInArr1(arr, elem, 0); }

    public static boolean elemInArr2(ArrayList<Integer> arr, int elem, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) return false;
        else if (elem < arr.get(mid)) high = mid - 1;
        else if (elem > arr.get(mid)) low = mid + 1;
        else if (elem == arr.get(mid)) return true;
        return elemInArr2(arr, elem, low, high);
    }

    public static <T> boolean elemInArr2(ArrayList<Integer> arr, int elem) { return elemInArr2(arr, elem, 0, arr.size() - 1); }

    public static double equation(Equation functionEq, double a, double b, double eps) {
        double mid = (b + a) / 2;
        if (Math.abs(b - a) <= 2 * eps) return a;
        else if (functionEq.f(mid) * functionEq.f(b) <= 0) a = mid;
        else b = mid;
        return equation(functionEq, a, b, eps);
    }

    public static double equation(Equation functionEq, double a, double b) { return equation(functionEq, a, b, 0.001); }

    public static double equation(Equation functionEq, double a) { return equation(functionEq, a, 10, 0.001); }

    public static double equation(Equation functionEq) { return equation(functionEq, 0, 10, 0.001); }

    public static void main(String[] args) {
//        Recursion.allNumber(50);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(35);
        arr.add(0);
        arr.add(65);
        arr.add(-24);
        arr.add(9);
        arr.add(123);
        arr.add(49);
//        System.out.println(elemInArr1(arr, 3));
        arr.sort(Comparator.comparingInt(x -> x));
//        System.out.println(elemInArr2(arr, -1));
//        Equation func = (x) -> Math.pow(x, 2) - 89 * x + 21;
//        System.out.printf("%.3f",equation(func));
        BinaryTreeSearch<String> bts = new BinaryTreeSearch<>();
        bts.add(10, "Dima");
        bts.add(35, "Artem");
        bts.add(3, "search");
        bts.add(71, "rain");
        bts.add(11, "tree");
        bts.add(15, "window");
        bts.add(8, "bank");
//        bts.traverseInOrder();
//        bts.traversePreOrder();
//        bts.traversePostOrder();
        bts.traverseLevelOrder();
//        String res = bts.search(8);
//        if (res == null) System.out.println("Нет такого ключа");
//        else System.out.println(res);
//        bts.delete(10);
//        res = bts.search(11);
//        if (res == null) System.out.println("Нет такого ключа");
//        else System.out.println(res);
    }
}
