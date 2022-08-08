package l3Наследование;

public class Square extends Shape {
    private double a;

    public Square (double a){
        this.a=a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    double getPerimetr() {
        return a*4;
    }

    @Override
    double getArea() {
        return a*a;
    }
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
