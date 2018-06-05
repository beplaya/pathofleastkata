import java.util.ArrayList;
import java.util.List;

public class MatrixBuilder {

    private List<Row> matrix;

    public MatrixBuilder() {
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

    //    public void print() {
//        for (int rI = 0; rI < matrix.size(); rI++) {
//            System.out.println("");
//            for (int cI = 0; cI < matrix.get(0).size(); cI++) {
//                System.out.printf("%s |", getMatrixValue(rI, cI));
//            }
//        }
//    }

    public void reset() {
        matrix = new ArrayList<>();
    }
}