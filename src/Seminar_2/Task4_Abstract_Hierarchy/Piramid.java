package Seminar_2.Task4_Abstract_Hierarchy;

public class Piramid extends Shape {
    double s, h;

    public Piramid(double s, double h) {
        this.s = s;
        this.h = h;
        super.volume = this.s * this.h / 3.0;
    }
}
