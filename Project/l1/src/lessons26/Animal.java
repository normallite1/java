package lessons26;

public class Animal implements Info {
    public int id;

    public Animal(int id){
        this.id = id;
    }

    public void sleep() {
        System.out.println("I am sliping");
    }
    public void infoShower(){
        System.out.println("Этот ид "+this.id);
    }
}
