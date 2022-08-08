package l4EXEPTION;

import java.util.Scanner;

public class Human {
    private String name;
    private int age;
    private Sex sex;

    public Human (String name, int age, Sex sex) {
        super();
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Human (Scanner scanner) {
        super();
        System.out.println("Name: ");
        this.name = scanner.nextLine();

        System.out.println("Age: ");
        this.age = Unity.inputIntValue(scanner);

        System.out.println("Sex: ");
        this.sex = Unity.inputSexValue(scanner);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    public String getInfo(){
        return "Name: "+getName()+" Age: "+getAge()+" Sex: "+getSex();
    }
}
