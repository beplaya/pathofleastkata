import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private List<Row> matrix;

    public Matrix() {
        reset();
    }

    public boolean addRow(Row row) {
        if (isSizeValid(row)) {
            matrix.add(row);
            return true;
        }
        return false;
    }

    private boolean isSizeValid(Row row) {
        if (row.size() >= Settings.COLUMN_MIN && row.size() <= Settings.COLUMN_MAX) {
            return matrix.size() > 0 ? row.size() == matrix.get(0).size() : true;
        }
        return false;
    }

    public int getRowCount() {
        return matrix.size();
    }

    public int getMatrixValue(int r, int c) {
        return matrix.get(r).getColumnValue(c);
    }

    public void reset() {
        matrix = new ArrayList<>();
    }

    public int getColumnCount() {
        return matrix.size() > 0 ? matrix.get(0).size() : 0;
    }

    public int getMatrixValue(CostFinder.Cursor cursor) {
        return getMatrixValue(cursor.getRow(), cursor.getColumn());
    }
}