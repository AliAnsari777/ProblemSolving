package Skillz;

import java.util.ArrayList;
import java.util.List;

public class PointTest {
    /**
     * Fix the problem in the following code by changing the Point class only,
     * without touching the code in main(). Make only the necessary changes.
     */

    static final class Point {
        private double x, y;

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // by overriding the "equal" method we can remove similar objects.
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Point)) {
                return false;
            }
            Point emp = (Point) obj;
            return emp.x == x && emp.y == y;
        }
    }

    public static void main(final String[] args) {
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1, 2));
        pointList.add(new Point(3, 4));
        System.out.println(pointList.size());
        // remove the second Point
        pointList.remove(new Point(3, 4));
        System.out.println(pointList.size());
        // Not removed!
    }
}
