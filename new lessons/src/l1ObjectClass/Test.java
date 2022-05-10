package l1ObjectClass;

public class Test {
    public static void main(String[] args){
        Cat cat1 = new Cat("Marta",9);
        Cat cat2 = new Cat("Marta",9);

        System.out.println(cat1.hashCode());
        System.out.println(cat2.hashCode());
        System.out.println(cat1.equals(cat2));


    }
}
