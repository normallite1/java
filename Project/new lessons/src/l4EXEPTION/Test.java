package l4EXEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static <list> void main(String[] args) {
        Student h1 = new Student("Bob", "Vazovsci", 16, Sex.MAN, Course.FIRST);
        Student h2 = new Student("Roma", "Prijmyk", 20, Sex.MAN, Course.FIRST);
        Student h3 = new Student("Kostia", "Gnatushun", 24, Sex.MAN, Course.FIRST);
        Student h4 = new Student("Igor", "Kurilo", 21, Sex.MAN, Course.FIRST);
        Student h5 = new Student("Andre", "Pilenkov", 30, Sex.MAN, Course.FIRST);
        Student h6 = new Student("Artur", "Mamonov", 27, Sex.MAN, Course.FIRST);
        Student h7 = new Student("David", "Iakin", 29, Sex.MAN, Course.FIRST);
        Student h8 = new Student("Irina", "Kuril", 28, Sex.WOMEN, Course.FIRST);
        Student h9 = new Student("Marina", "Marchenko", 23, Sex.WOMEN, Course.FIRST);
        Student h10 = new Student("Ruslan", "Vachenko", 26, Sex.MAN, Course.FIRST);
        Student h11 = new Student("Nikolai", "Olesko", 26, Sex.MAN, Course.FIRST);

        Group group = new Group();

     //   Student h12 = group.consoleCreateStudent();
     //   group.push(h12, 9);

        try {
            group.push(h1, 0);
            group.push(h2, 1);
            group.push(h3, 2);
            group.push(h4, 3);
            group.push(h5, 4);
            group.push(h6, 5);
            group.push(h7, 6);
            group.push(h8, 7);
            group.push(h9, 8);
            group.push(h10, 9);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        group.filterAbc();






//                .flatMapToInt(n -> n.getName().chars())
//                .filter(n -> n =='A')
//                .collect(Collectors.toCollection(ArrayList::new));

//        group.sortByName();
//        System.out.println(group);
//        System.out.println("Search student");
//        group.searce();
//
//        System.out.println(Arrays.toString(group.voenCom()));
//
//        group.sortAage();
//        System.out.println(group);


    }
}