import java.util.ArrayList;
import java.util.List;

public class Path implements Comparable<Path> {

    private List<Point> points = new ArrayList<>();

    public int getCost() {
        int cost = 0;
        for (Point p : points) {
            cost += p.cost;
        }
        return cost;
    }

    public Path addPoint(int row, int column, int cost) {
        points.add(new Point(row, column, cost));
        return this;
    }

    public void print() {
        String pstr = "";
        for (Point p : points) {
            pstr += (p.row + 1) + ",";
        }
        System.out.printf("%s - %d%n", pstr, getCost());
    }

    public static Path fromPath(Path path) {
        Path newPath = new Path();
        for (Point pt : path.points) {
            newPath.addPoint(pt.row, pt.column, pt.cost);
        }
        return newPath;
    }

    @Override
    public int compareTo(Path otherPath) {
        return this.getCost() - otherPath.getCost();
    }

    public boolean isComplete(Matrix matrix) {
        return points.size() == matrix.getColumnCount();
    }

    public int[] getOneBasedRows() {
        int[] rows = new int[points.size()];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = points.get(i).row + 1;
        }
        return rows;
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
