package Lessons43VlogClass;

public class Electrocar {
    private int id;

    private class Motor{

        public void startMotor() {
            System.out.println("Motor "+id+" is start");
        }
    }
        public  Electrocar(int id){
            this.id =  id;

    }
    public void start(){
        Motor motor = new Motor();
        motor.startMotor();
        System.out.println("Car "+id+" is start");
    }
}
