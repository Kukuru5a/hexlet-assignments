package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo() {
        return 0;
    }

    @Override
    public int compareTo(Home another) {
        Cottage cottage = new Cottage(area, floorCount);
        var res = another.getArea() > cottage.getArea() ? -1 : 1;
        return res;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }

    public static void main(String[] args) {
        var home = new Cottage(125.5, 3);
//        System.out.println(home);
        var home2 = new Cottage(112, 1);
        System.out.println(home2.compareTo(home));
    }
}
// END
