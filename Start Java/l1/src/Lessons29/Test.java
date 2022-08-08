package Lessons29;

public class Test {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        Animal d1 = new Dog();
        Animal c1 = new Cat();
        test(a1);
        test(d1);
        test(c1);

    }
    public static void test(Animal animal){
        animal.eat();
    }
}
