import java.util.ArrayList;
import java.util.List;

public class Path {

    List<Point> points = new ArrayList<>();

    public int getCost() {
        int cost = 0;
        for (Point p : points) {
            cost += p.cost;
        }
        return cost;
    }

    public Path addPoint(int row, int column, int cost) {
       return addPoint(new Point(row, column, cost));
    }

    public void print() {
        System.out.println("");
        for (Point p : points) {
            System.out.printf("%s,%s - %s%n", p.row+1, p.column+1, p.cost);
        }
        System.out.println(getCost());
    }

    public static Path fromPath(Path path) {
        Path newPath = new Path();
        for (Point pt: path.points) {
            path.addPoint(pt);
        }
        return newPath;
    }

    private Path addPoint(Point pt) {
        points.add(pt);
        return this;
    }

    public class Point {
        public final int row;
        public final int column;
        public final int cost;

        public Point(int row, int column, int cost) {
            this.row = row;
            this.column = column;
            this.cost = cost;
        }
    }
}
