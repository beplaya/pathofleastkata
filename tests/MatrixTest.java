import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private Matrix matrix;

    @Before
    public void setup() {
        matrix = new Matrix();
    }

    @Test
    public void itValidatesMatrixColumnSize() {
        assertFalse(matrix.addRow(new Row()));
        int[] tooBig = new int[Settings.COLUMN_MAX + 1];
        assertFalse(matrix.addRow(new Row(tooBig)));
        int[] min = new int[Settings.COLUMN_MIN];
        int[] max = new int[Settings.COLUMN_MAX];
        assertTrue(matrix.addRow(new Row(min)));
        matrix.reset();
        assertTrue(matrix.addRow(new Row(max)));
    }

    @Test
    public void itAddsTheRowToTheMatrix() {
        for (int rI = 0; rI < Settings.ROW_MAX; rI++) {
            int[] rowValues = new int[Settings.COLUMN_MAX];
            for (int cI = 0; cI < Settings.COLUMN_MAX; cI++) {
                rowValues[cI] = cI;
            }
            assertTrue(matrix.addRow(new Row(rowValues)));
        }
        assertEquals(Settings.ROW_MAX, matrix.getRowCount());
        for (int rI = 0; rI < Settings.ROW_MAX; rI++) {
            for (int cI = 0; cI < Settings.COLUMN_MAX; cI++) {
                assertEquals(cI, matrix.getMatrixValue(rI, cI));
            }
        }
    }

    @Test
    public void itRejectsChangesInColumnCount() {
        assertTrue(matrix.addRow(new Row(new int[Settings.COLUMN_MAX])));
        assertFalse(matrix.addRow(new Row(new int[Settings.COLUMN_MIN])));
    }


}