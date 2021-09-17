import java.util.*;

/*
http://codeforces.com/contest/144/problem/B
 */
public class BMeeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xa = sc.nextInt();
        int ya = sc.nextInt();
        Point a = new Point(xa, ya);
        int xb = sc.nextInt();
        int yb = sc.nextInt();
        int r_num = sc.nextInt();
        Point b = new Point(xb, yb);
        Point c = new Point(xa, yb);
        Point d = new Point(xb, ya);
        int result = 0;

        List<Point> points = new ArrayList<>(1_000_000);
        List<Circle> rads = new ArrayList<>(r_num);
        for (int i = 0; i < r_num; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int r = sc.nextInt();
            rads.add(new Circle(x, y, r));
        }

        points.add(a);
        points.add(b);
        points.add(c);
        points.add(d);
        Collections.sort(points);


        for (int i = points.get(0).y; i <= points.get(1).y; i++) {
            Point point = new Point(points.get(0).x, i);
            result = getABlanket(rads, point, result);

        }

        for (int i = points.get(1).x + 1; i < points.get(3).x; i++) {
            Point point = new Point(i, points.get(1).y);
            result = getABlanket(rads, point, result);

        }
        for (int i = points.get(3).y; i >= points.get(2).y; i--) {
            Point point = new Point(points.get(2).x, i);
            result = getABlanket(rads, point, result);

        }

        for (int i = points.get(0).x + 1; i < points.get(2).x; i++) {
            Point point = new Point(i, points.get(0).y);
            result = getABlanket(rads, point, result);

        }
        System.out.println(result);


    }

    static int getABlanket(List<Circle> rads, Point point, int result) {
        boolean valid = false;

        for (int j = 0; j < rads.size(); j++) {
            if (rads.get(j).isPointInCircle(point)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            result += 1;
        }
        return result;
    }

    static class Point implements Comparable<Point> {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x;
        int y;

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Point o) {
            int result = Integer.compare(x, o.x);
            if (result == 0) {
                result = Integer.compare(y, o.y);
            }
            return result;
        }
    }

    static class Circle {
        Point point;
        int r;

        public Circle(int x, int y, int r) {
            this.point = new Point(x, y);
            this.r = r;
        }

        boolean isPointInCircle(Point p) {
            double xs = Math.pow((p.x - point.x), 2);
            double ys = Math.pow((p.y - point.y), 2);
            double result = Math.sqrt(xs + ys);
            return r >= result;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "point=" + point +
                    ", r=" + r +
                    '}';
        }
    }


}
