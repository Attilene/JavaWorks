package Seminar_2.Task3_Hierarchy;

public class Parallelepiped extends Shape{
    double s, h;

    public Parallelepiped(double s, double h) {
        this.s = s;
        this.h = h;
        super.volume = this.s * this.h;
    }
}
