package l3Наследование;

public class Test {
    public static void main(String[] args) {

        Shape t1 = new Triangle(new Point(1,1), new Point(5,4), new Point(3,1));
        Shape s1 = new Square(4);
        Shape r1 = new Rectangle(2,3);
        Shape c1 = new Circule(5);

        Board board = new Board();

        board.push(t1,0);
        board.push(s1,1);
        board.push(r1,2);
        board.push(c1,3);
        System.out.println(board.getInfo());
    }
}
