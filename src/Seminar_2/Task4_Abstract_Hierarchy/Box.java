package Seminar_2.Task4_Abstract_Hierarchy;

public class Box extends Shape {
    public Box() {
        super.volume = 150;
    }

    public boolean add(Shape figure) {
        if (figure.getVolume() > super.volume) {
            System.out.println("В коробке не хватает места для новой фигуры!");
            return false;
        }
        this.volume -= figure.volume;
        return true;
    }
}
