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
    public void itFindsAPathCost() {
        Matrix matrix1 = getTestMatrix1();
        Path path = costFinder.getLeastCostPath(matrix1);
        path.print();
        assertNotNull(path);
        assertEquals(16, path.getCost());
    }

    private Matrix getTestMatrix1() {
        Matrix matrix = new Matrix();
        matrix.addRow(new Row(3, 4, 1, 2, 8, 6));
        matrix.addRow(new Row(6, 1, 8, 2, 7, 4));
        matrix.addRow(new Row(5, 9, 3, 9, 9, 5));
        matrix.addRow(new Row(8, 4, 1, 3, 2, 6));
        matrix.addRow(new Row(3, 7, 2, 8, 6, 4));

        return matrix;
    }

}