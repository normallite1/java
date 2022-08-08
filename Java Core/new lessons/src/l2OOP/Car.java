package l2OOP;

public class Car {
    String color;
    double weight;
    int years;
    private double speed=0;

    public Car (String color, double weight, int years){
        this.color = color;
        this.weight = weight;
        this.years = years;
        this.speed = speed;
    }
    public void speeding (int a){
        speed = speed+a;
        return;
    }
    Car repeintCar (Car a, String newColor){
       a.color = newColor;
       return a;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", years=" + years +
                '}';
    }
    public void print (){
        System.out.println(color);
    }
}
