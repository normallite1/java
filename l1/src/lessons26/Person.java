package lessons26;

public class Person implements Info {
    public String name;

    public Person(String name){
        this.name = name;
    }

    public void hello(){
        System.out.println("Hello");
    }
    public void infoShower(){
        System.out.println("Это имя "+this.name);
    }
}
