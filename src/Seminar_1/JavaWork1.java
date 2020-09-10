package Seminar_1;

import jdk.jfr.Unsigned;

import java.util.*;

public class JavaWork1 {

    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] s = new int[30];
        for (int i = 0; i < s.length; i++) {
            s[i] = (int) (Math.random() * 100);
        }
        Vector v = new Vector();
        for (int i = 0; i < 30; i++) {
            v.addElement((int) (Math.random() * 100));
        }
        vecout(v);
//        s = puzir(s);
//        System.out.println("\n");
//        for (int i = 0; i < s.length; i++) {
//            System.out.print(s[i] + " ");
//        }
//        int[] r = new int[50];
//        r = prostotak();
//        for (int i = 0; i < r.length; i++) {
//            if (r[i] != 0) {
//                System.out.print(r[i] + " ");
//            }
//        }
//        int a = 5;
//        a++;
//        a = a + 1;
//        System.out.println(a);
//        int b = 12;
//        int c = 15;
//        int d = b;
//        b = c;
//        c = d;
//        int r = 3;
//        int t = 4;
//        System.out.println((int)Math.sqrt(Math.pow(r, 2) + Math.pow(t, 2)));
//        int q = 1267;
//        System.out.println(q % 10);
//        System.out.println(raz21(100));
//        System.out.println(middlearif(10, 2));
//        System.out.println(middlegeom(3, 9));
//        System.out.println(rast(0, 1, 3, 10));
    }

    public static int raz21(int raz) {
        return raz - 21;
    }

    public static int middlearif(int a, int b) {
        return (a + b) / 2;
    }

    public static int middlegeom(int a, int b) {
        return (int) Math.sqrt(a * b);
    }

    public static double rast(double x1, double y1, double x2, double y2) {
        double a = x2 - x1;
        double b = y2 - y1;
        return Math.pow(Math.pow(a, 2) + Math.pow(b, 2), 0.5);
    }

    public static int[] puzir(int[] s) {
        int d = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s.length - 1; j++) {
                if (s[j + 1] < s[j]) {
                    d = s[j + 1];
                    s[j + 1] = s[j];
                    s[j] = d;
                }
            }
        }
        return s;
    }


    public static int[] prostotak() {
        int s[] = new int[50];
        int q = 0;
        for (int i = 2; i < 101; i++) {
            boolean t = true;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && j > 1 && i != j) {
                    t = false;
                    break;
                }
            }
            if (t) {
                s[q] = i;
                q++;
            }
        }
        return s;
    }

    public static void vecout(Vector v) {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();
    }

}





