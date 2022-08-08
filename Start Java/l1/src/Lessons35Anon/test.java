package Lessons35Anon;

interface AbleToEat {
    public void eat();
}

public class test {
    public static void main(String[] args) {
       AbleToEat a1 = new AbleToEat() {
           @Override
           public void eat() {
               System.out.println("One animal eat...");
           }
       };
a1.eat();
    }
}
