package l6colection;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       String [] str = {"1","2","3","4","5","6","7","8","9","10"};
        LinkedList<String> list = new LinkedList<>();
        list.addAll(List.of(str));
        list.removeFirst();
        list.removeFirst();
        list.removeLast();

        System.out.println(list);

    }
}
