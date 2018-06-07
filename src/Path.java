import java.util.ArrayList;
import java.util.List;

public class Path implements Comparable<Path> {

    private List<Point> points = new ArrayList<>();
    private boolean forcedComplete = false;

    public int getCost() {
        int cost = 0;
        for (Point p : points) {
            cost += p.cost;
        }
        return cost;
    }

    public Path addPoint(int row, int column, int cost) {
        Point point = new Point(row, column, cost);
        if (cost + getCost() > Settings.MAX_COST) {
            forcedComplete = true;
        } else if (isValidPoint(point)) {
            points.add(point);
        }
        return this;
    }

    private boolean isValidPoint(Point point) {
        if (points.isEmpty()) {
            return true;
        } else if (point.column == points.get(points.size() - 1).column + 1) {
            return true;
        }
        return false;
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
        return forcedComplete || isFullPath(matrix);
    }

    public int[] getOneBasedRows() {
        int[] rows = new int[points.size()];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = points.get(i).row + 1;
        }
        return rows;
    }

    public boolean isFullPath(Matrix matrix) {
        return points.size() == matrix.getColumnCount();
    }

    public int size() {
        return points.size();
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
