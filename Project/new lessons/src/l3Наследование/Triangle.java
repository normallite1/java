package l3Наследование;

public class Triangle extends Shape {
    private Point x;
    private Point y;
    private Point z;

    public Triangle(Point x, Point y, Point z) {
        this.x =x;
        this.y=y;
        this.z=z;
    }

    public Point getZ() {
        return z;
    }

    public void setZ(Point z) {
        this.z = z;
    }

    @Override
    double getPerimetr(){
            return Point.calculateDistance(x, y) + Point.calculateDistance(y,z) + Point.calculateDistance(z,x);
    }

    @Override
     double getArea(){
        double p = this.getPerimetr()/2;
        return  Math.sqrt(p*(p- Point.calculateDistance(x, y)))*(p-Point.calculateDistance(y,z))*(p-Point.calculateDistance(z,x));
        }

    @Override
    public String getName() {
            return this.getClass().getSimpleName();

    }


}
