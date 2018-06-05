import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixBuilderTest {

    private MatrixBuilder matrixBuilder;

    @Before
    public void setup() {
        matrixBuilder = new MatrixBuilder();
    }

    @Test
    public void itValidatesMatrixColumnSize() {
        assertFalse(matrixBuilder.addRow(new Row()));
        int[] tooBig = new int[Settings.COLUMN_MAX + 1];
        assertFalse(matrixBuilder.addRow(new Row(tooBig)));
        int[] min = new int[Settings.COLUMN_MIN];
        int[] max = new int[Settings.COLUMN_MAX];
        assertTrue(matrixBuilder.addRow(new Row(min)));
        matrixBuilder.reset();
        assertTrue(matrixBuilder.addRow(new Row(max)));
    }

    @Test
    public void itAddsTheRowToTheMatrix() {
        for (int rI = 0; rI < Settings.ROW_MAX; rI++) {
            int[] rowValues = new int[Settings.COLUMN_MAX];
            for (int cI = 0; cI < Settings.COLUMN_MAX; cI++) {
                rowValues[cI] = cI;
            }
            assertTrue(matrixBuilder.addRow(new Row(rowValues)));
        }
        assertEquals(Settings.ROW_MAX, matrixBuilder.getRowCount());
        for (int rI = 0; rI < Settings.ROW_MAX; rI++) {
            for (int cI = 0; cI < Settings.COLUMN_MAX; cI++) {
                assertEquals(cI, matrixBuilder.getMatrixValue(rI, cI));
            }
        }
    }

    @Test
    public void itRejectsChangesInColumnCount() {
        assertTrue(matrixBuilder.addRow(new Row(new int[Settings.COLUMN_MAX])));
        assertFalse(matrixBuilder.addRow(new Row(new int[Settings.COLUMN_MIN])));
    }


}