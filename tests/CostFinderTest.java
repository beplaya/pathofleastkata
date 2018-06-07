import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CostFinderTest {

    private CostFinder costFinder;

    @Before
    public void setup() {
        costFinder = new CostFinder();
    }

    @Test
    public void itFindsAPath() {
        verifyMatrix(new PathResult(16, true, new int[]{1, 2, 3, 4, 4, 5}), getTestMatrixYes16_123445());
        verifyMatrix(new PathResult(11, true, new int[]{1, 2, 1, 5, 4, 5}), getTestMatrixYes11_121545());
    }

    @Test
    public void itDoesntFindAPath() {
        verifyMatrix(new PathResult(50, false, new int[]{1, 3, 1}), getTestMatrixNo50_131());
    }

    private void verifyMatrix(PathResult expectedPathResult, Matrix matrix) {
        Path path = costFinder.getLeastCostPath(matrix);
        assertNotNull(path);
        PathResult actualPathResult = new PathResult(path, matrix);
//        path.print();
        assertEquals(expectedPathResult.isFullPath, actualPathResult.isFullPath);
        assertEquals(expectedPathResult.cost, actualPathResult.cost);
        assertArray(expectedPathResult.getOneBasedRows(), actualPathResult.getOneBasedRows());
    }

    private void assertArray(int[] expected, int[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

    private Matrix getTestMatrixNo50_131() {
        Matrix matrix = new Matrix();
        //19, 12, 20
        matrix.addRow(new Row(19, 10, 19, 10, 19));
        matrix.addRow(new Row(21, 23, 20, 19, 12));
        matrix.addRow(new Row(20, 12, 20, 11, 10));
        return matrix;
    }

    private Matrix getTestMatrixYes16_123445() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 8, 6, 4));

        return matrix;
    }


    private Matrix getTestMatrixYes11_121545() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 1, 2, 3));
        return matrix;
    }

}