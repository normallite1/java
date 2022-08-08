package l2OOP.home;

public class Test {
    public static void main(String[] args) {
        Cat cat1 = new Cat("My",9);
        cat1.info();
        cat1.reName(cat1,"By");
        cat1.info();
    }
}
