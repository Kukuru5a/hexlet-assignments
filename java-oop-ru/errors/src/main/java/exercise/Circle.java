package exercise;

// BEGIN
public class Circle {
    Point point;
    static int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public static int getRadius() {
        return radius;
    }
    public static double getSquare() throws NegativeRadiusException {
        double s = Math.PI* (getRadius() * getRadius());
        if (radius >= 0) {
            return s;
        }
        throw new NegativeRadiusException("Не удалось посчитать площадь");
    }


}
// END
