package Lessons38Exeption2;

import java.io.IOException;
import java.util.Scanner;

public class Exeption2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Double x = Double.parseDouble(scanner.next());
            if (x != 0) throw new IOException();
        } catch (Exception e) {
            System.out.println("Вы ввели не 0");
        }


    }

}
