package l3Наследование;

public class Rectangle  extends Shape{
    private double a;
    private double b;
    public Rectangle (double a, double b){
        this.a=a;
        this.b=b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    double getPerimetr() {
        return (a+b)*2;
    }

    @Override
    double getArea() {
        return a*b;
    }
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
