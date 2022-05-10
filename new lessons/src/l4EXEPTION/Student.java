package l4EXEPTION;

import java.util.Scanner;

import static kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.number;

public class Student extends Human {
    private String surname;
    private Course course;

    public Student(String name, String surname, int age, Sex sex,Course course) {
        super(name, age, sex);
        this.surname = surname;
        this.course = course;
    }

    public Student (Scanner scanner) {
        super(scanner);
        scanner.nextLine();

        System.out.println("Surname: ");
        this.surname = scanner.nextLine();

        System.out.println("Course: ");
        this.course=Unity.inputCourseValue(scanner);

    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    public String getInfo(){
        return "Name: "+getName()+" Surname: "+getSurname()+" Age: "+getAge()+" Sex: "+getSex()+" Course: " + getCourse();
    }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", course=" + course +
                "}\n";
    }

}
