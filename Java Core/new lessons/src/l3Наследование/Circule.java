package l3Наследование;

public class Circule extends Shape {
    private double radius;

    public Circule (double radius){
        this.radius = radius;
    }

    @Override
    double getPerimetr() {
        return 2*Math.PI*radius;
    }

    @Override
    double getArea() {
        return Math.PI*radius*2;
    }
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
