package l2OOP;

public class Test {
    public static void main(String [] args){
     Car car1 = new Car("Red",1800,2010);
     System.out.println(car1);
     car1=car1.repeintCar(car1,"Blue");
     System.out.println(car1.toString());
    }
}
