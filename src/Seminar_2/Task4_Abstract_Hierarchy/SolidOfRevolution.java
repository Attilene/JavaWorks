package Seminar_2.Task4_Abstract_Hierarchy;

public abstract class SolidOfRevolution extends Shape {
    double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}
