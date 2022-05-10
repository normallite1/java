import java.util.Scanner;

public class Swich {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vedi vozrast");
        int age = scanner.nextInt();
        switch (age) {
            case 10 :
                System.out.println("Skolota");
                break;
            case 15 :
                System.out.println("Pervii class");
                break;
            case 20 :
                System.out.println("Uvazuha");
                break;
            default:
                System.out.println("lox");
        }
    }
}
