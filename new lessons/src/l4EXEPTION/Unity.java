package l4EXEPTION;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Unity {
    public Unity() {
        super();
    }

    public static Sex inputSexValue(Scanner sc) {
        Sex result = Sex.MAN;
        boolean success = false;

        while (!success) {
            int code = inputIntValue(sc);
            if (code == 0) {
                result = Sex.MAN;
                success = true;
            }  if (code == 1) {
                result = Sex.WOMEN;
                success = true;
            } else {
                System.out.println("Invalid value, try again --");
            }
        }

        return result;
    }



    public static int inputIntValue(Scanner sc) {
        int result = 0;
        boolean success = false;

        while (!success) {
            try {
                result = sc.nextInt();
                success = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid value, try again");
                sc.next();
                success = false;
            }
        }

        return result;
    }
    public static Course inputCourseValue(Scanner scanner) {
        Course result = Course.FIRST;
        boolean success = false;

        while (!success) {
            int code = inputIntValue(scanner);
            if (code == 1) {
                result = Course.FIRST;
                success = true;
            }  if (code == 2) {
                result = Course.SECOND;
                success = true;
            }  if (code == 3) {
                result = Course.THIRD;
                success = true;
            } else {
                System.out.println("Invalid value, try again --");
            }
        }

        return result;
    }
}
