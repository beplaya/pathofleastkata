import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CostFinder {




    public Path getLeastCostPath(Matrix matrix) {

        Path leastCostPath = null;
        Cursor[] cursors = new Cursor[matrix.getRowCount()];
        List<Path> paths = new ArrayList<>();
        for (int i = 0; i < cursors.length; i++) {
            cursors[i] = new Cursor().startAt(i, 0);
            paths.addAll(cursors[i].discoverPaths(matrix, null));
        }




        return leastCostPath;
    }

    public class Cursor {
        private int row = 0;
        private int column = 0;

        public Cursor startAt(int row, int column) {
            this.row = row;
            this.column = column;
            return this;
        }

        public List<Path> discoverPaths(Matrix matrix, Path startPath) {
            List<Path> paths = new ArrayList<>();
            Path path = startPath == null ? new Path() : startPath;
            path.addPoint(row, column, matrix.getMatrixValue(this));


            return paths;
        }

        private Path createPath(Matrix matrix) {


            return null;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }


    }
}
