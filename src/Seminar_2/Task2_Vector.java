package Seminar_2;

public class Task2_Vector {
    double x, y, z;

    public Task2_Vector(double[] vec) {
        this.x = vec[0];
        this.y = vec[1];
        this.z = vec[2];
    }

    public double length() {
//        Метод для нахождения длины вектора
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }

    public double scalyar(Task2_Vector vect2) {
//        Метод для скалярного произведения векторов
        return x * vect2.x + y * vect2.y + z * vect2.z;
    }

    public Task2_Vector mult(Task2_Vector vect2) {
//        Метод для векторного произведения векторов
        Task2_Vector vect3 = new Task2_Vector(new double[]{0, 0, 0});
        vect3.x = y * vect2.z - z * vect2.y;
        vect3.y = z * vect2.x - x * vect2.z;
        vect3.z = x * vect2.y - y * vect2.x;
        return vect3;
    }

    public double angle(Task2_Vector vect2) {
//        Метод для нахождения угла между векторами
        double cos = this.scalyar(vect2) / (this.length() * vect2.length());
        return Math.toDegrees(Math.acos(cos));
    }

    public Task2_Vector plus(Task2_Vector vect2) {
//        Метод для сложения векторов
        Task2_Vector vect3 = new Task2_Vector(new double[]{0, 0, 0});
        vect3.x = x + vect2.x;
        vect3.y = y + vect2.y;
        vect3.z = z + vect2.z;
        return vect3;
    }

    public Task2_Vector minus(Task2_Vector vect2) {
//        Метод для вычитания веткоров
        Task2_Vector vect3 = new Task2_Vector(new double[]{0, 0, 0});
        vect3.x = x - vect2.x;
        vect3.y = y - vect2.y;
        vect3.z = z - vect2.z;
        return vect3;
    }

    public static Task2_Vector[] arrvec(int N) {
//        Метод для создания массива случайных векторов
        Task2_Vector[] arrv = new Task2_Vector[N];
        for (int i = 0; i < N; i++) {
            arrv[i] = new Task2_Vector(new double[]{0, 0, 0});
        }
        for (int i = 0; i < N; i++) {
            arrv[i].x = Math.random() * 20000 - 10000;
            arrv[i].y = Math.random() * 20000 - 10000;
            arrv[i].z = Math.random() * 20000 - 10000;
        }
        return arrv;
    }

    public static void vectorOut(Task2_Vector vect) {
//        Метод для вывода вектора в консоль
        System.out.println("Coordinates of math`s vector: (" + vect.x + ", " + vect.y + ", " + vect.z + ")");
    }
}
