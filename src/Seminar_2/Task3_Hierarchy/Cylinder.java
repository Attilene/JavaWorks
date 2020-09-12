package Seminar_2.Task3_Hierarchy;

public class Cylinder extends SolidOfRevolution{
    double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
        super.volume = Math.PI * Math.pow(super.radius, 2) * this.height;
    }
}
