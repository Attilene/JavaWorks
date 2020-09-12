package Seminar_2.Task3_Hierarchy;

public class Ball extends SolidOfRevolution{
    public Ball(double radius) {
        super(radius);
        super.volume = (4 * Math.PI * Math.pow(super.radius, 3) / 3.0);
    }
}
