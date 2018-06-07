import java.util.*;

public class CostFinder {


    public Path getLeastCostPath(Matrix matrix) {

        Path leastCostPath = null;
        Cursor[] cursors = new Cursor[matrix.getRowCount()];
        List<Path> paths = new ArrayList<>();
        for (int i = 0; i < cursors.length; i++) {
            cursors[i] = new Cursor(i, 0);
            paths.addAll(cursors[i].discoverPaths(matrix, null));
        }
        Collections.sort(paths);
        leastCostPath = paths.isEmpty() ? null : paths.get(0);
        return leastCostPath;
    }

    public class Cursor {
        private int row = 0;
        private int column = 0;

        public Cursor(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public List<Path> discoverPaths(Matrix matrix, Path startPath) {
            List<Path> paths = new ArrayList<>();
            Path path = startPath == null ? new Path() : Path.fromPath(startPath);
            path.addPoint(row, column, matrix.getMatrixValue(this));
            if (path.isComplete(matrix)) {
                paths.add(path);
            } else {
                int[] rowChoices = new int[3];
                //up row
                rowChoices[0] = row == 0 ? matrix.getRowCount() - 1 : row - 1;
                //down row
                rowChoices[1] = row == matrix.getRowCount() - 1 ? 0 : row + 1;
                //same row
                rowChoices[2] = row;
                for (int rowChoiceIndex = 0; rowChoiceIndex < rowChoices.length; rowChoiceIndex++) {
                    int rowChoice = rowChoices[rowChoiceIndex];
                    for (int col = column + 1; col < matrix.getColumnCount(); col++) {
                        paths.addAll(new Cursor(rowChoice, col).discoverPaths(matrix, path));
                    }
                }
            }

            return paths;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }


    }
}
