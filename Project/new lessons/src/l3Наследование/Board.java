package l3Наследование;

public class Board {
    private Shape[] part = new Shape[4];
    public Board() {
        super();
    }
    public void push(Shape shape, int i) {
        if (part[i] == null) {
            part[i] = shape;
            System.out.println("Фигруа " + shape.getName() + " была положена в " + i + " блок");
        } else {
            System.out.println("Занято, блять");
        }
    }
    public void delete(int i) {
        if (part[i] != null) {
            String figureName = part[i].getName();
            part[i] = null;
            System.out.println("Shape " + figureName + " was successfully delete from " + i + " cell.");
        }
    }
        public  String getInfo() {
            String shapesName = "";
            double shapesArea = 0;
            for (int i = 0; i < part.length; i++) {
                if (part[i] != null) {
                    shapesName += part[i].getName() + " , ";
                    shapesArea += part[i].getArea();
                }
            }
            return "There are such shapes: " + shapesName + " areas = " + String.format("%.2f", shapesArea);
        }

    }

