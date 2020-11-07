package Seminar_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Recursion {
    public static void allNumber(int n) {
        if (n != 1) allNumber(n - 1);
        System.out.println(n);
    }

    public static <T> boolean elemInArr1(ArrayList<T> arr, T elem, int index) {
        if (index == arr.size()) return false;
        else if (elem == arr.get(index)) return true;
        return elemInArr1(arr, elem, index + 1);
    }

    public static <T> boolean elemInArr1(ArrayList<T> arr, T elem) {
        return elemInArr1(arr, elem, 0);
    }

    public static boolean elemInArr2(ArrayList<Integer> arr, int elem, int low, int high) {
        int mid = (low + high) / 2;
        if (low > high) return false;
        else if (elem < arr.get(mid)) high = mid - 1;
        else if (elem > arr.get(mid)) low = mid + 1;
        else if (elem == arr.get(mid)) return true;
        return elemInArr2(arr, elem, low, high);
    }

    public static <T> boolean elemInArr2(ArrayList<Integer> arr, int elem) {
        return elemInArr2(arr, elem, 0, arr.size() - 1);
    }

    public static void binaryTreeSearch() {
        
    }

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
        System.out.println(elemInArr2(arr, -1));
    }
}
