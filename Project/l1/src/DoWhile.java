import java.util.Scanner;
public class DoWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s;
        do{
            System.out.println("Vedite 5 bla");
            s = scanner.nextInt();
        } while(s!=5);
        System.out.println("Molodec");
    }
}
